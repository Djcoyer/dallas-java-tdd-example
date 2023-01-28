package com.dcoyer.dallasjavatdd.controller;


import com.dcoyer.dallasjavatdd.service.HelloWorldService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldControllerIT {
    @MockBean
    private HelloWorldService service;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void init() {

    }

    @Test
    public void givenValidRequest_whenGetGreetingIsCalled_thenReturns200Status() throws Exception {
        //arrange

        //Note: The value we get back from the service/controller isn't important here.
        // We validated that in unit tests, now we're validating things like route
        // Status code, etc.
        when(this.service.greet()).thenReturn("Hello, World!");

        //act
        mockMvc.perform(get("/greet")).andExpect(
                status().isOk()
        );

        //assert

    }
}
