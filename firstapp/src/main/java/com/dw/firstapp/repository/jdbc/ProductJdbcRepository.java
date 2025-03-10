package com.dw.firstapp.repository.jdbc;

import com.dw.firstapp.dto.ProductRequestDTO;
import com.dw.firstapp.model.Product;
import com.dw.firstapp.repository.iface.ProductRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductJdbcRepository implements ProductRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    @Override
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        String query = "select * from 제품";
        try (
                Connection connection = DriverManager.getConnection(
                        URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {
            System.out.println("데이터베이스 연결 성공");

            while (resultSet.next()) {
                Product product = new Product();

                product.setProductNumber(resultSet.getInt("제품번호"));
                product.setProductName(resultSet.getString("제품명"));
                product.setProductPackagingUnit((resultSet.getString("포장단위")));
                product.setPrice(resultSet.getInt("단가"));
                product.setInventory(resultSet.getInt("재고"));

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return products;
    }

    @Override
    public Product getProductById(int productNumber) {
        Product product = new Product();
        String query = "select * from 제품 where 제품번호 = ?";
        try (
                Connection connection = DriverManager.getConnection(
                        URL, USER, PASSWORD);
                PreparedStatement pstmt = connection.prepareStatement(query);
        ) {
            System.out.println("데이터베이스 연결 성공");
            pstmt.setInt(1, productNumber);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    product.setProductNumber(resultSet.getInt("제품번호"));
                    product.setProductName(resultSet.getString("제품명"));
                    product.setProductPackagingUnit(resultSet.getString("포장단위"));
                    product.setPrice(resultSet.getInt("단가"));
                    product.setInventory(resultSet.getInt("재고"));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return product;
    }

    @Override
    public Product saveProduct(Product product) {
        String query = "insert into 제품(제품번호, 제품명, 포장단위, 단가, 재고) "
                + "values (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, product.getProductNumber());
            pstmt.setString(2, product.getProductName());
            pstmt.setString(3, product.getProductPackagingUnit());
            pstmt.setInt(4, product.getPrice());
            pstmt.setInt(5, product.getInventory());
            pstmt.executeUpdate();
            System.out.println("INSERT 성공");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 매개변수로 전달받은 department 객체 정보를 MySQL에 insert한 후
        // 성공이면 해당 객체를 리턴함
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        String query = "update 제품 set 제품번호=? where 제품명 =? , 포장단위=? , 단가=? , 재고=? ";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, product.getProductNumber());
            pstmt.setString(2, product.getProductName());
            pstmt.setString(3, product.getProductPackagingUnit());
            pstmt.setInt(4, product.getPrice());
            pstmt.setInt(5, product.getInventory());
            pstmt.executeUpdate();
            System.out.println("UPDATE 성공");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
    @Override
    public String deleteProduct(String id) {
        String query = "delete from 제품 where 제품번호 = ?";
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            System.out.println("DELETE 성공");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public List<Product> getProductsBelowPrice(double price) {
        return List.of();
    }

    @Override
    public String updateProductWithStock(int id, int stock) {
        return "";
    }

    @Override
    public List<Product> getProductByProductName(String name) {
        return List.of();
    }

    @Override
    public List<Product>getProductsByStockValue() {
        return List.of();
    }
}
