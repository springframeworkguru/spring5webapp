package com.springframework.spring6di;

import com.springframework.spring6di.controllers.MyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class Spring6diApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    MyController myController;

    @Test
    void testAutowireOfController(){
        System.out.println(myController.sayHello());
    }
    @Test
    void testControllerFromCtx(){
        MyController myController = applicationContext.getBean(MyController.class);

        System.out.println(myController.sayHello());
    }
    @Test
    void contextLoads() {
    }

}
