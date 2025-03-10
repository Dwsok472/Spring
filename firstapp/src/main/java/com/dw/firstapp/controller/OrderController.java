package com.dw.firstapp.controller;

import com.dw.firstapp.dto.OrderRequestDTO;
import com.dw.firstapp.model.Employee;
import com.dw.firstapp.model.Order;
import com.dw.firstapp.model.Product;
import com.dw.firstapp.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/find-all-orders")
    public ResponseEntity<List<Order>> getAllOrder() {
        return new ResponseEntity<>(
                orderService.getAllOrder(),
                HttpStatus.OK
        );
    }

    @GetMapping("/orders/{orderNumber}")
    public ResponseEntity<Order> getOrderById(@PathVariable String orderNumber) {
        return new ResponseEntity<>(
                orderService.getOrderById(orderNumber),
                HttpStatus.ACCEPTED
        );
    }

    @GetMapping("/orders/{productNumber}/{customerId}")
    public ResponseEntity<List<Order>> getOrderByIdAndCustomer(@PathVariable int productNumber,
                                                               @PathVariable String customerId) {
        return new ResponseEntity<>(
                orderService.getOrderByIdAndCustomer(productNumber, customerId),
                HttpStatus.ACCEPTED
        );
    }

    @PostMapping("/orders")
    public  ResponseEntity<OrderRequestDTO> saveOrder(
    @RequestBody OrderRequestDTO orderRequestDTO) {
    return new ResponseEntity<>(
            orderService.saveOrder(orderRequestDTO),
            HttpStatus.CREATED
    );
    }

    // 4-4 주문번호와 발송일을 매개변수로 해당 주문의 발송일을 수정하는 API
    @PutMapping("/update")
    public ResponseEntity<String> updateOrderWithShippingDate(@RequestParam String id, @RequestParam String date){
        try {
            // 주문 발송일 업데이트 처리
            boolean isUpdated = orderService.updateShippingDate(id, date);

            if (isUpdated) {
                return ResponseEntity.ok("주문 발송일이 성공적으로 업데이트되었습니다.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("주문을 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류가 발생했습니다.");
        }
    }

    @GetMapping("/orders/city/orderNumber/{limit}")
    public ResponseEntity<List<Map<String, Integer>>> getTopCitiesByTotalOrderAmount(@PathVariable int limit){

        return new ResponseEntity<>(
                orderService.getTopCitiesByTotalOrderAmount(limit),
                HttpStatus.ACCEPTED
        );
    }

    @GetMapping("/orders/ordercount/year/{city}")
    public ResponseEntity<List<Map<String ,Double>>> getOrderCountByYearForCity(@PathVariable String city) {

        return new ResponseEntity<>(
                orderService.getOrderCountByYearForCity(city),
                HttpStatus.ACCEPTED
        );
    }

    @PostMapping("/orders1")
    public ResponseEntity<OrderRequestDTO> saveOrder2(
            @RequestBody OrderRequestDTO orderRequestDTO) {
        return new ResponseEntity<>(
                orderService.saveOrder2(orderRequestDTO),
                HttpStatus.CREATED
        );
    }

}
