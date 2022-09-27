package guru.springframework.spring5webapp.money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class MoneyTest {

    @Test
    public void testMultiplication() {
        Euro five = new Euro(5);
        Euro product = five.times(2);
        assertEquals(10, product.amount);

        product = five.times(3);
        assertEquals(15, product.amount);
    }
}
