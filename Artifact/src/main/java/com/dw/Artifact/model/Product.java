package com.dw.Artifact.model;

public class Product {
    private int productNumber; // 제품번호
    private String productName; // 제품명
    private String productPackagingUnit; // 포장단위
    private int price; // 단가
    private int inventory; // 재고

    public int getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(int productTotal) {
        this.productTotal = productTotal;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNumber=" + productNumber +
                ", productName='" + productName + '\'' +
                ", productPackagingUnit='" + productPackagingUnit + '\'' +
                ", price=" + price +
                ", inventory=" + inventory +
                ", productTotal=" + productTotal +
                '}';
    }

    public Product(int productTotal) {
        this.productTotal = productTotal;
    }

    private int productTotal; // 총주문건수

    public Product(int productNumber, String productName,
                   String productPackagingUnit, int price, int inventory) {
        this.productNumber = productNumber;
        this.productName = productName;
        this.productPackagingUnit = productPackagingUnit;
        this.price = price;
        this.inventory = inventory;
    }

    public Product() {

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

    public String getProductPackagingUnit() {
        return productPackagingUnit;
    }

    public void setProductPackagingUnit(String productPackagingUnit) {
        this.productPackagingUnit = productPackagingUnit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

}
