package com.dcoyer.dallasjavatdd.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    public String greet() {
        return "Hello, World!";
    }
}
