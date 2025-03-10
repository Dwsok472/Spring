package com.dw.firstapp.repository.template;

import com.dw.firstapp.exception.ResourceNotFoundException;
import com.dw.firstapp.model.Order;
import com.dw.firstapp.repository.iface.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

@Repository
public class OrderTemplateRepository implements OrderRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final RowMapper<Order> orderRowMapper = new RowMapper<Order>() {
        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            Order order = new Order();
            order.setOrderNumber(rs.getString("주문번호"));
            order.setGuestNumber(rs.getString("고객번호"));
            order.setEmployeeNumber(rs.getString("사원번호"));
            order.setOrderdate((rs.getDate("주문일").toLocalDate()));
            order.setRequestDate((rs.getDate("요청일").toLocalDate()));
            order.setDepartDate((rs.getDate("발송일").toLocalDate()));
            return order;
        }
    };

    @Override
    public List<Order> getAllOrder() {
        String query = "select * from 주문";
        return jdbcTemplate.query(query,orderRowMapper);
    }

    @Override
    public Order getOrderById(String id2) {
        String query = "select * from 주문 where 주문번호 = ?";
        try {
            return jdbcTemplate.queryForObject(query, orderRowMapper, id2);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(
                    "주문번호가 올바르지 않습니다 : " + id2
            );
        }
    }
    @Override
    public List<Order> getOrderByIdAndCustomer(int productNumber, String customerId) {
        String query = "select * from 주문 where 고객번호 = ? and" +
                " 주문번호 in (select 주문번호 from 주문세부 where 제품번호 = ?)";
       return jdbcTemplate.query(query, orderRowMapper, productNumber, customerId);
    }

    @Override
    public int saveOrder(Order order) {
        String query = "insert into 주문(주문번호,고객번호,사원번호,주문일,요청일)" +
                "values(?, ?, ?, ?, ?)";

        return jdbcTemplate.update(query,
                order.getOrderNumber(),
                order.getGuestNumber(),
                order.getEmployeeNumber(),
                order.getOrderdate().toString(),
                order.getRequestDate().toString());
    }

    @Override
    public List<Order> updateOrderWithShippingDate() {
        return List.of();
    }

    @Override
    public List<Order> updateOrderWithShippingDate(String id, String date) {
        String query = "select * from 주문 where 주문번호 = ? and 발송일 = ?";
        return Collections.singletonList(jdbcTemplate.queryForObject(query, orderRowMapper, id, date));
    }

    @Override
    public Optional<Order> findById(String id) {
        return Optional.empty();
    }

    @Override
    public void save(Order order) {

    }
    @Override
    public List<Map<String, Object>> getTopCitiesByTotalOrderAmount(int limit) {
        String query = "select 도시, sum(단가 * 주문수량) as 주문금액합 " +
                "from 주문 " +
                "inner join 고객 " +
                "on 주문.고객번호 = 고객.고객번호 " +
                "inner join 주문세부 " +
                "on 주문.주문번호 = 주문세부.주문번호 " +
                "group by 도시 " +
                "order by 주문금액합 desc " +
                "limit ?";

        return jdbcTemplate.queryForList(query, limit);
    }

    @Override
    public List<Map<String, Object>> getOrderCountByYearForCity(String city) {
        String query = "select year(주문일) as 주문년도, count(*) as 주문건수 " +
                "from 주문 " +
                "join 고객 on 주문.고객번호 = 고객.고객번호 " +
                "where 고객.도시 = ? " +
                "group by 주문년도 " +
                "order by 주문년도 ";

        return jdbcTemplate.queryForList(query,city);
    }
    @Override
    public int saveOrder2(Order order) {
        String query = "insert into 주문(주문번호,고객번호,사원번호,주문일,요청일)" +
                "values(?, ?, ?, ?, ?)";

        return jdbcTemplate.update(query,
                order.getOrderNumber(),
                order.getGuestNumber(),
                order.getEmployeeNumber(),
                order.getOrderdate().toString(),
                order.getRequestDate().toString());
    }

}
