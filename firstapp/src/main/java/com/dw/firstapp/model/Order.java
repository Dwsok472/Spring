package com.dw.firstapp.model;

import java.time.LocalDate;

public class Order {
    private String orderNumber; // 주문번호
    private String guestNumber; // 고객번호
    private String employeeNumber; // 사원번호
    private LocalDate orderdate; // 주문일
    private LocalDate requestDate; // 요청일
    private LocalDate shippingDate; // 발송일

    public Order() {
        this.orderNumber = orderNumber;
        this.guestNumber = guestNumber;
        this.employeeNumber = employeeNumber;
        this.orderdate = orderdate;
        this.requestDate = requestDate;
        this.shippingDate = shippingDate;
    }

    public Order(String 주문번호, String 고객번호, String 사원번호, LocalDate 주문일, LocalDate 요청일, LocalDate 발송일) {
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getGuestNumber() {
        return guestNumber;
    }

    public void setGuestNumber(String guestNumber) {
        this.guestNumber = guestNumber;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public LocalDate getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(LocalDate orderdate) {
        this.orderdate = orderdate;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public LocalDate getDepartDate() {
        return shippingDate;
    }

    public void setDepartDate(LocalDate departDate) {
        this.shippingDate = departDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", guestNumber='" + guestNumber + '\'' +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", orderdate=" + orderdate +
                ", requestDate=" + requestDate +
                ", departDate=" + shippingDate +
                '}';
    }

    public void setShippingDate(LocalDate parse) {

    }

    public void setproductId(String productId) {
    }
}
