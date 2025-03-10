package com.dw.firstapp.service;

import com.dw.firstapp.dto.OrderRequestDTO;
import com.dw.firstapp.exception.InvalidRequestException;
import com.dw.firstapp.exception.ResourceNotFoundException;
import com.dw.firstapp.model.Order;
import com.dw.firstapp.model.OrderDetail;
import com.dw.firstapp.model.Product;
import com.dw.firstapp.repository.iface.OrderDetailRepository;
import com.dw.firstapp.repository.iface.OrderRepository;
import com.dw.firstapp.repository.iface.ProductRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class OrderService {
    @Autowired
    @Qualifier("orderTemplateRepository")
    OrderRepository orderRepository;
    @Autowired
    @Qualifier("orderDetailTemplateRepository")

    OrderDetailRepository orderDetailRepository;

    @Autowired
    @Qualifier("productTemplateRepository")
    ProductRepository productRepository;
    public List<Order> getAllOrder() {
        return orderRepository.getAllOrder();
    }

    public Order getOrderById(String orderNumber) {
        return orderRepository.getOrderById(orderNumber);
    }

    public List<Order> getOrderByIdAndCustomer(int productNumber, String customerId) {
        List<Order> orders = orderRepository.getOrderByIdAndCustomer(productNumber, customerId);
        if (orders.isEmpty()) {
            throw new ResourceNotFoundException("조건에 일치하는 주문정보가 없습니다 : " + productNumber + "," + customerId);
        } else {
            return orders;
        }
    }

    public OrderRequestDTO saveOrder(OrderRequestDTO orderRequestDTO) {
        // 1.DTO에서 주문정보를 꺼내 주문테이블에 insert
        orderRepository.saveOrder(orderRequestDTO.toOrder());
        // 2.DTO에서 주문세부정보를 꺼내 주문세부테이블에 insert. 반복문필요
        for (OrderDetail data : orderRequestDTO.getOrderDetails()) {
            orderDetailRepository.saveOrderDetail(data);
        }
        return orderRequestDTO;
    }

    // 4-4 주문번호와 발송일을 매개변수로 해당 주문의 발송일을 수정하는 API
    public boolean updateOrderWithShippingDate(String id, String date) {
        Optional<Order> orderOptional = orderRepository.findById(id);

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setShippingDate(LocalDate.parse(date));
            orderRepository.save(order);
            return true;
        }

        return false;
    }

    public boolean updateShippingDate(String id, String date) {
        return false;
    }

    public List<Map<String, Integer>> getTopCitiesByTotalOrderAmount(int limit) {
        List<Map<String, Integer>> orderList = new ArrayList<>();

        List<Map<String, Object>> mapList =
                orderRepository.getTopCitiesByTotalOrderAmount(limit);

        for (Map<String, Object> data : mapList) {
            Map<String, Integer> mapput = new HashMap<>();

            mapput.put("주문금액합", Integer.valueOf(data.get("주문금액합").toString()));

            orderList.add(mapput);
        }
        return orderList;
    }

    public List<Map<String, Double>> getOrderCountByYearForCity(String city) {
        List<Map<String, Double>> orderList = new ArrayList<>();

        List<Map<String, Object>> mapList =
                orderRepository.getOrderCountByYearForCity(city);

        for (Map<String, Object> data : mapList) {
            Map<String, Double> mapput = new HashMap<>();

            mapput.put("주문건수", Double.valueOf(data.get("주문건수").toString()));

            orderList.add(mapput);
        }
        return orderList;
    }

    // @Transactional은 선언된 메서드 수행도중  예외가 발생하면 이미 수행되었던
    // 동작을 모두 롤백(rollback=완성복귀) 시키도록 명령하는 어노테이션임
    // 주문세부의 특정 제품의 재고가 부족해서 예외가 발생하면 전체 주문,  주문세부의
    // 저장되었던 내용들은 모두 취소되고 롤백됨!!
    public OrderRequestDTO saveOrder2(OrderRequestDTO orderRequestDTO) {
        orderRepository.saveOrder(orderRequestDTO.toOrder());

        for (OrderDetail data : orderRequestDTO.getOrderDetails()) {
            Product product = productRepository.getProductById(data.getProductNumber());

            if (data.getOrderQuantity() > product.getInventory()) {
                throw new InvalidRequestException(
                        "요청하신 수량은 현재 재고를 초과합니다 : " + product.getInventory()
                );
            } else {
                orderDetailRepository.saveOrderDetail(data);
            }
        }return orderRequestDTO;
    }
}
