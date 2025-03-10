package com.dw.firstapp.repository.jdbc;

import org.springframework.stereotype.Repository;

@Repository
public class HelloJdbcRepository {
    public String hello() {
        return "Hello world from repository";
    }
}
