package com.dw.companyapp.repository;

import com.dw.companyapp.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface OrderRepository extends JpaRepository <Order, String > {
    @Query("SELECT o FROM Order o " +
            "JOIN OrderDetail od ON o.orderId = od.order.orderId " +
            "WHERE od.product.productId = :productNumber " +
            "AND o.customer.customerId = :customerId")
    List<Order> OrderByIdAndCustomer(int productNumber , String customerId);

    @Query("SELECT o.customer.city AS city, SUM(od.unitPrice * od.orderQuantity) AS totalAmount " +
            "FROM Order o " +
            "JOIN o.orderDetails od " +
            "JOIN o.customer c " +
            "GROUP BY c.city " +
            "ORDER BY totalAmount DESC")
    List<Object[]> getTopCitiesByTotalOrderAmount();

    @Query("SELECT EXTRACT(YEAR FROM o.orderDate) AS year, COUNT(o) AS orderCount " +
            "FROM Order o " +
            "JOIN o.customer c " +
            "WHERE c.city = :city " +
            "GROUP BY EXTRACT(YEAR FROM o.orderDate) " +
            "ORDER BY year ASC")
    List<Object[]>getOrderCountByYearForCity(String city);
}
