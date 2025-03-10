package com.dw.firstapp.controller;

import com.dw.firstapp.dto.ProductRequestDTO;
import com.dw.firstapp.model.Department;
import com.dw.firstapp.model.Employee;
import com.dw.firstapp.model.Product;
import com.dw.firstapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductsController {
    @Autowired
    ProductService productsService;

    @GetMapping("/find-all-products")
    public ResponseEntity<List<Product>> getAllProduct() {
        return new ResponseEntity<>(
                productsService.getAllProduct(),
                HttpStatus.ACCEPTED
        );
    }
    @GetMapping("/product/{productNumber}")
    public ResponseEntity<Product> getProductById(@PathVariable int productNumber){
        return new ResponseEntity<>(
                productsService.getProductById(productNumber),
                HttpStatus.ACCEPTED
        );
    }
    @PostMapping("/post/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(
                productsService.saveProduct(product),
                HttpStatus.ACCEPTED
        );
    }

    @PostMapping("/post/productlist")
    public ResponseEntity<List<Product>> saveProductList(
            @RequestBody List<Product> productList) {
        return new ResponseEntity<>(
                productsService.saveProductList(productList),
                HttpStatus.ACCEPTED
        );
    }
    @PutMapping("/put/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return new ResponseEntity<>(
                productsService.updateProduct(product),
                HttpStatus.CREATED
        );
    }
    @DeleteMapping("/delete/product")
    public ResponseEntity<String> deleteProduct(@RequestParam String id){
        return new ResponseEntity<>(
                "제품번호 : " + productsService.deleteProduct(id) + " 가 삭제되었습니다.",
                HttpStatus.OK
        );
    }
    @GetMapping("/product")
    public ResponseEntity<List<Product>>getProductsBelowPrice(@RequestParam double price_below){
        return new ResponseEntity<>(
                productsService.getProductsBelowPrice(price_below),
                HttpStatus.OK);
    }

    @PutMapping("/products/update")
    public ResponseEntity<String> updateProductWithStock(@RequestParam int id, @RequestParam int stock) {
        return new ResponseEntity<>(
                productsService.updateProductWithStock(id,stock),
                HttpStatus.ACCEPTED
        );
    }

    @GetMapping("/products/name/{name}")
    public ResponseEntity<List<Product>> getupdateProductWithStock(@PathVariable String name) {

        return new ResponseEntity<>(
                productsService.getProductByProductName(name),
                HttpStatus.ACCEPTED
        );
    }
    @GetMapping("/products/stockvalue")
    public ResponseEntity<List<ProductRequestDTO>> getProductsByStockValue() {
        return new ResponseEntity<>(
                productsService.getProductsByStockValue(),
                HttpStatus.ACCEPTED
        );
    }
}
