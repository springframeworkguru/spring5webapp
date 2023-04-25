package com.springframework.spring6di.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyControllerTest {

    @Test
    void sayHello() {

        MyController myController = new MyController();
        System.out.println(myController.sayHello());
    }
}