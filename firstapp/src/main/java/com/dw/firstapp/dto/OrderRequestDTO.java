package com.dw.firstapp.dto;

import com.dw.firstapp.model.Order;
import com.dw.firstapp.model.OrderDetail;

import java.time.LocalDate;
import java.util.List;

public class OrderRequestDTO {
    private String orderId;
    private String customerId;
    private String employeeId;
    private LocalDate requestDate;
    private List<OrderDetail> orderDetails;
    private String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public OrderRequestDTO(String productId) {
        this.productId = productId;
    }

    public OrderRequestDTO() {
    }

    public OrderRequestDTO(String orderId, String customerId,
                           String employeeId, LocalDate requestDate, List<OrderDetail> orderDetails) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.requestDate = requestDate;
        this.orderDetails = orderDetails;

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
    @Override
    public String toString() {
        return "OrderRequestDTO{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", requestDate=" + requestDate +
                ", orderDetails=" + orderDetails +
                ", productId=" + productId +
                '}';
    }
    public Order toOrder() {
        Order order = new Order();
        order.setOrderNumber(this.orderId);
        order.setGuestNumber(this.customerId);
        order.setEmployeeNumber(this.employeeId);
        order.setOrderdate(LocalDate.now());
        order.setRequestDate(this.requestDate);
        order.setproductId(this.productId);
        return order;
    }

}
