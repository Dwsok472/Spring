package com.dw.firstapp2.service;

import com.dw.firstapp2.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    @Autowired
    Repository repository;

    public String hello() {
        return repository.hello();
    }

}
