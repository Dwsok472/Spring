package com.dw.companyapp.service;

import com.dw.companyapp.dto.OrderRequestDTO;
import com.dw.companyapp.exception.InvalidRequestException;
import com.dw.companyapp.model.*;
import com.dw.companyapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Transactional
@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // 과제 1-2 주문번호를 기준으로 주문 정보를 조회하는 API
    // 과제 3-2 주문정보를 조회할때 주문번호가 올바르지 않은 경우의 예외 처리
    public Order getOrderById(String orderNumber) {
        return orderRepository.findById(orderNumber)
                .orElseThrow(() -> new RuntimeException("해당정보를 찾을수 없습니다."));
    }

    public List<Order> getOrderByIdAndCustomer(int productNumber, String customerId) {
        List<Order> orders = orderRepository.OrderByIdAndCustomer(productNumber, customerId);
        if (orders.isEmpty()) {
            throw new RuntimeException("해당 정보가 없습니다.");
        }
        return orders;
    }

    public OrderRequestDTO saveOrder(OrderRequestDTO orderRequestDTO) {
        Order order = new Order();
        order.setOrderId(orderRequestDTO.getOrderId());
        order.setCustomer(customerRepository.findById(orderRequestDTO.getCustomerId())
                .orElseThrow(()->new InvalidRequestException("없는 고객번호")));
        order.setEmployee(employeeRepository.findById(orderRequestDTO.getEmployeeId())
                .orElseThrow(()->new InvalidRequestException("없는 사원번호")));
        order.setOrderDate(LocalDate.now());
        order.setRequestDate(orderRequestDTO.getRequestDate());
        orderRepository.save(order);

        for (OrderDetail data : orderRequestDTO.getOrderDetails()) {
            Product product = productRepository.findById(data.getProduct().getProductId())
                    .orElseThrow(()->new InvalidRequestException("없는 제품번호"));
            if (product.getStock() - data.getOrderQuantity() < 0) {
                throw new InvalidRequestException(
                        "요청하신 수량은 현재 재고를 초과합니다: " +
                                product.getProductName() + ", 현재 재고 " +
                                product.getStock());
            }
            orderDetailRepository.save(data);
        }
        return orderRequestDTO;
    }


    // 과제 4-4 주문번호와 발송일을 매개변수로 해당 주문의 발송일을 수정하는 API
    public String updateOrderWithShippingDate(String id, String date) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (!optionalOrder.isPresent()) {
            throw new RuntimeException("해당주문을 찾을수 없습니다.");
        }

        Order order = optionalOrder.get();
        order.setShippingDate(LocalDate.parse(date));
        orderRepository.save(order);

        return "주문 발송일이 성공적으로 수정되었습니다.";
    }

    // 과제 4-5 도시별로 주문금액합 결과를 내림차순 정렬하여 조회하는 API
    public List<Map<String, Double>> getTopCitiesByTotalOrderAmount(int limit) {
        List<Object[]> queryResult = orderRepository.getTopCitiesByTotalOrderAmount();

        List<Map<String, Double>> result = new ArrayList<>();

        for (Object[] row : queryResult) {
            Map<String, Double> cityData = new HashMap<>();
            String city = (String) row[0];
            Double totalAmount = (Double) row[1];
            cityData.put(city, totalAmount);
            result.add(cityData);
        }

        return result;
    }


    // 과제 4-6 도시를 매개변수로 해당 도시의 년도별 주문건수를 조회하는 API
    public List<Map<String, Double>> getOrderCountByYearForCity(String city) {
        List<Object[]> queryResult = orderRepository.getOrderCountByYearForCity(city);

        List<Map<String, Double>> result = new ArrayList<>();

        for (Object[] row : queryResult){
            Map<String,Double> cityData = new HashMap<>();
            String year = String.valueOf(row[0]);
            Double orderCount = ((Number) row[1]).doubleValue();
            cityData.put(year,orderCount);
            result.add(cityData);
        }
        return result;
    }
}