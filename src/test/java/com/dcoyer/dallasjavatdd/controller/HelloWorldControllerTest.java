package com.dcoyer.dallasjavatdd.controller;

import com.dcoyer.dallasjavatdd.service.HelloWorldService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class HelloWorldControllerTest {

    private HelloWorldController helloWorldController;
    private HelloWorldService helloWorldService;

    @BeforeEach
    public void init() {
        this.helloWorldService = Mockito.mock(HelloWorldService.class);
        this.helloWorldController = new HelloWorldController(this.helloWorldService);
    }

    @Test
    public void givenValidRequest_whenGetGreetingIsCalled_thenReturnCorrectGreeting() {
        //arrange
        String expectedGreeting = "Hello, World!";

        //act
        String actualGreeting = helloWorldController.getGreeting();

        //assert
        assertEquals(expectedGreeting, actualGreeting);
    }

    @Test
    public void givenValidRequest_whenGetGreetingIsCalled_thenReturnGreetingFromServiceLayer() {
        //arrange
        String expectedGreeting = "Hello, Universe!";
        when(helloWorldService.greet()).thenReturn(expectedGreeting);

        //act
        String actualGreeting = helloWorldController.getGreeting();

        //assert
        assertEquals(expectedGreeting, actualGreeting);
        verify(this.helloWorldService, Mockito.times(1)).greet();
    }
}
