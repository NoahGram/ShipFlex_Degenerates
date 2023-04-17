import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyTest {
    @Test
    void testCustomerTypes() {
        Customer customer = new Customer();
        String actual = customer.getTypes().get(0);
        String expected = "Private";
        assertEquals(expected, actual);
    }

    @Test
    void ExhaustTypePickerTest() {
        BoatType boatType = new BoatType("Test", 1, 0, "Slow");
        ExhaustTypePicker exhaustTypePicker = new ExhaustTypePicker();
        exhaustTypePicker.selectExhaust(boatType);
    }

    @Test
    void CreateBoatAssemblyWithCustomerIsSucces() {
        BoatType boatType = new BoatType("Test", 1, 0, "Slow");
        BoatAssembly boatAssembly = new BoatAssembly();
        boatAssembly.selectedBoat = new Boat(boatType);
        boatAssembly.boatOfferte(new Customer());                                                                       
    }
}
