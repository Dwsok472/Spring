package com.dw.firstapp.repository.jdbc;

import com.dw.firstapp.model.OrderDetail;
import com.dw.firstapp.repository.iface.OrderDetailRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDetailJdbcRepository implements OrderDetailRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    @Override
    public List<OrderDetail> getAllOrderDetail() {
        List<OrderDetail> orderDetails = new ArrayList<>();
        String query = "select * from 주문세부";
        try (
                Connection connection = DriverManager.getConnection(
                        URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {
            System.out.println("데이터베이스 연결 성공");

            while (resultSet.next()) {
                OrderDetail orderDetail = new OrderDetail();

                orderDetail.setOrderNumber(resultSet.getString("주문번호"));
                orderDetail.setProductNumber(resultSet.getInt("제품번호"));
                orderDetail.setPrice(resultSet.getInt("단가"));
                orderDetail.setOrderQuantity(resultSet.getInt("주문수량"));
                orderDetail.setDiscountRate((int) resultSet.getDouble("할인율"));


                orderDetails.add(orderDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return orderDetails;

    }

    @Override
    public int saveOrderDetail(OrderDetail orderDetail) {
        return 0;
    }
}
