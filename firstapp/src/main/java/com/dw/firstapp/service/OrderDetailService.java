package com.dw.firstapp.service;

import com.dw.firstapp.model.OrderDetail;
import com.dw.firstapp.repository.iface.OrderDetailRepository;
import com.dw.firstapp.repository.jdbc.OrderDetailJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    @Qualifier("orderDetailTemplateRepository")
    OrderDetailRepository orderDetailRepository;

    public List<OrderDetail> getAllOrderDetail(){
        return orderDetailRepository.getAllOrderDetail();
    }
}

