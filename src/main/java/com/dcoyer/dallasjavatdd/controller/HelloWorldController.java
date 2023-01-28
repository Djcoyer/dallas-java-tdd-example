package com.dcoyer.dallasjavatdd.controller;

import com.dcoyer.dallasjavatdd.service.HelloWorldService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private HelloWorldService helloWorldService;

    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping("/greet")
    public String getGreeting() {
        return this.helloWorldService.greet();
    }
}
