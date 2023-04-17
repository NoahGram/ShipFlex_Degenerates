import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class MyTest {
    @Test
    void testCustomerTypes() {
        Customer customer = new Customer();
        String actual = customer.getTypes().get(0);
        String expected = "Private";
        assertEquals(expected, actual);
    }
}
