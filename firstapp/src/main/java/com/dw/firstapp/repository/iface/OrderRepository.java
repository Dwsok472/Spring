package com.dw.firstapp.repository.iface;

import com.dw.firstapp.model.Order;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrderRepository {
    List<Order> getAllOrder();
    Order getOrderById(String id2);
    List<Order> getOrderByIdAndCustomer(int productNumber, String customerId);
    int saveOrder(Order order);
    List<Order> updateOrderWithShippingDate();
    List<Order> updateOrderWithShippingDate(String id, String date);

    Optional<Order> findById(String id);

    void save(Order order);

    List<Map<String, Object>> getTopCitiesByTotalOrderAmount(int limit);

    List<Map<String, Object>> getOrderCountByYearForCity(String city);

    int saveOrder2(Order order);
}
