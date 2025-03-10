package com.dw.firstapp.repository.iface;

import com.dw.firstapp.dto.ProductRequestDTO;
import com.dw.firstapp.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProduct();
    Product getProductById(int productNumber);
    Product saveProduct(Product product);
    Product updateProduct(Product product);
    String deleteProduct(String id);
    List<Product>getProductsBelowPrice(double price);
    String updateProductWithStock(int id, int stock);
    List<Product>getProductByProductName(String name);
    List<Product>getProductsByStockValue();
}
