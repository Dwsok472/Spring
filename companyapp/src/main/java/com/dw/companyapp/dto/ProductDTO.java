package com.dw.companyapp.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProductDTO {
    private int productId;
    private String productName;
    private double unitPrice;
    private int stock;
    private double stockValue; // 재고금액 = 단가 * 재고

    public ProductDTO(long productId, String productName, double unitPrice, int stock) {
        this.productId = (int) productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.stockValue = unitPrice * stock;
    }
}
