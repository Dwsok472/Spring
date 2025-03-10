package com.dw.firstapp.service;

import com.dw.firstapp.repository.jdbc.HelloJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    @Autowired
    HelloJdbcRepository helloRepository;

    public String hello() {
        return helloRepository.hello();
    }
}
