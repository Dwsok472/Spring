package com.dw.firstapp.controller;

import com.dw.firstapp.model.OrderDetail;
import com.dw.firstapp.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping("/find-all-orderdetails")
    public ResponseEntity<List<OrderDetail>> getALLOrderDetail(){
        return new ResponseEntity<>(
                orderDetailService.getAllOrderDetail(),
                HttpStatus.ACCEPTED
        );
    }
}
