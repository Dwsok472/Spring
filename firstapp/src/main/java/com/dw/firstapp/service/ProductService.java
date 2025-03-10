package com.dw.firstapp.service;

import com.dw.firstapp.dto.ProductRequestDTO;
import com.dw.firstapp.exception.InvalidRequestException;
import com.dw.firstapp.model.Product;
import com.dw.firstapp.repository.iface.ProductRepository;
import com.dw.firstapp.repository.jdbc.ProductJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    @Qualifier("productTemplateRepository")
    ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    public Product getProductById(int productNumber) {
        if (productNumber < 0) {
            throw new InvalidRequestException("존재하지 않는 제품번호: " + productNumber);
        }
        return productRepository.getProductById(productNumber);
    }

    public Product saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }

    public List<Product> saveProductList(List<Product> productList) {
        for (Product data : productList) {
            productRepository.saveProduct(data);
        }
        return productList;
    }

    public Product updateProduct(Product product) {
        return productRepository.updateProduct(product);
    }

    public String deleteProduct(String id) {
        return productRepository.deleteProduct(id);
    }

    public List<Product> getProductsBelowPrice(double price) {
        return productRepository.getProductsBelowPrice(price);
    }

    public String updateProductWithStock(int id, int stock) {
        return productRepository.updateProductWithStock(id, stock);
    }

    public List<Product> getProductByProductName(String name) {
        return productRepository.getProductByProductName(name);
    }

    public List<ProductRequestDTO> getProductsByStockValue() {
        List<Product> products = productRepository.getProductsByStockValue();
        List<ProductRequestDTO> productRequestDTOList = new ArrayList<>();
        for (Product product : products){
            ProductRequestDTO productRequestDTO = new ProductRequestDTO();

            productRequestDTO.setProductName(product.getProductName());
            productRequestDTO.setProductNumber(product.getProductNumber());
            productRequestDTO.setprice(product.getPrice());
            productRequestDTO.setStock(product.getInventory());
            productRequestDTO.setStockValue(product.getPrice(), product.getInventory());

            productRequestDTOList.add(productRequestDTO);
        }
        return productRequestDTOList;
    }
}


