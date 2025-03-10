package com.dw.Artifact.sevice;

import com.dw.Artifact.repository.HelloRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    @Autowired
    HelloRepositroy helloRepositroy;

    public String hello() {
        return helloRepositroy.hello();
    }

}
