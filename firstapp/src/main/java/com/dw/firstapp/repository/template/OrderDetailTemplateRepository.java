package com.dw.firstapp.repository.template;

import com.dw.firstapp.model.OrderDetail;
import com.dw.firstapp.model.OrderDetail;
import com.dw.firstapp.repository.iface.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderDetailTemplateRepository implements OrderDetailRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final RowMapper<OrderDetail> orderDetailRowMapper = new RowMapper<OrderDetail>() {
        @Override
        public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderNumber(rs.getString("주문번호"));
            orderDetail.setProductNumber(rs.getInt("제품번호"));
            orderDetail.setPrice(rs.getInt("단가"));
            orderDetail.setOrderQuantity(rs.getInt("주문수량"));
            orderDetail.setDiscountRate((int) rs.getDouble("할인율"));
            return orderDetail;
        }
    };

    @Override
    public List<OrderDetail> getAllOrderDetail() {
        String query = "select * from 주문세부";
        return jdbcTemplate.query(query,orderDetailRowMapper);

    }

    @Override
    public int saveOrderDetail(OrderDetail orderDetail) {
        String query = "insert into 주문세부 (주문번호,제품번호,단가,주문수량,할인율) "+
                "values(?,?,?,?,?)";
        return jdbcTemplate.update(query,
                orderDetail.getOrderNumber(),
                orderDetail.getProductNumber(),
                orderDetail.getPrice(),
                orderDetail.getOrderQuantity(),
                orderDetail.getDiscountRate());
    }
}
