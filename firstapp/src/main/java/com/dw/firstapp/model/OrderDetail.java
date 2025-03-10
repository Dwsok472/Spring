package com.dw.firstapp.model;

public class OrderDetail {
    private String orderNumber; // 주문번호
    private int productNumber; // 제품번호
    private int price; // 단가
    private int orderQuantity; // 주문수량
    private double discountRate; // 할인율

    public OrderDetail() {
        this.orderNumber = orderNumber;
        this.productNumber = productNumber;
        this.price = price;
        this.orderQuantity = orderQuantity;
        this.discountRate = discountRate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderNumber='" + orderNumber + '\'' +
                ", productNumber=" + productNumber +
                ", price=" + price +
                ", orderQuantity=" + orderQuantity +
                ", discountRate=" + discountRate +
                '}';
    }
}
