package com.dw.firstapp.dto;

import com.dw.firstapp.model.Product;

public class ProductRequestDTO {
    private int productNumber;
    private String productName;
    private double price;
    private int stock;
    private double stockValue; // 재고금액 = 단가 * 재고

    public ProductRequestDTO() {
    }

    public ProductRequestDTO(int productNumber, String productName, double price, int stock, double stockValue) {
        this.productNumber = productNumber;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.stockValue = stockValue;
    }

    // 아래 fromProduct()와 동일한 기능을 가진 생성자를 만들 수 있음
    public ProductRequestDTO(Product product) {
        this.productNumber= product.getProductNumber();
        this.productName = product.getProductName();
        this.price = product.getPrice();
        this.stock = product.getInventory();
        this.stockValue = product.getPrice() * product.getInventory();
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getprice() {
        return price;
    }

    public void setprice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getStockValue() {
        return stockValue;
    }

    public void setStockValue(int stock , double price) {
        this.stockValue = (double) stock * price;
    }

    public Product toProduct() {
        Product product = new Product();
        product.setProductNumber(this.productNumber);
        product.setProductName(this.productName);
        product.setPrice((int) this.price);
        product.setInventory(this.stock);

        return product;
    }
}