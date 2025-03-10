package com.dw.firstapp.repository.iface;

import com.dw.firstapp.model.OrderDetail;

import java.util.List;

public interface OrderDetailRepository {
    List<OrderDetail> getAllOrderDetail();
    int saveOrderDetail(OrderDetail orderDetail);
}
