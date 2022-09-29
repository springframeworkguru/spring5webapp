package guru.springframework.spring5webapp.junit5intro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GreetingTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("___before all___");
    }

    Greeting greeting;
    @BeforeEach
    void setUp() {
        System.out.println("...before each...");
        greeting = new Greeting();
    }

    @Test
    void helloWorld() {
        System.out.println(greeting.helloWorld());
    }

    @Test
    void helloWorldWithName() {
        System.out.println(greeting.helloWorld("Milan"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("...after each...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("___after all___");
    }
}