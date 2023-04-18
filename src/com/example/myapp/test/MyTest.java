import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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

    @Test
    void CreateNewBoat() {
        ArrayList<BoatType> boatTypes = new ArrayList<BoatType>();
        MotorType Honda = new MotorType("Honda", 5, 500);
        RoomType stateroon = new RoomType("Stateroom", 4, 1100);
        SteeringWheelType wood = new SteeringWheelType("Wood", 3, 450);
        ExhaustType doublePipe = new ExhaustType("Double Pipe", 2, 400);
        ColorType pearlescent = new ColorType("Pearlescent", 2, 1000);
        WaterType swimmingPool = new WaterType("Swimming Pool", 2, 4500);
        FlagType medium = new FlagType("Medium", 2, 60);
        AnchorType hook = new AnchorType("Hook", 2, 30);

        BoatType boatType = new BoatType("Tester", 1, 1500000, "Medium");
        boatTypes.add(boatType);
        boatType.AddMotor(Honda);
        boatType.AddRoom(stateroon);
        boatType.AddSteeringWheel(wood);
        boatType.AddExhaust(doublePipe);
        boatType.AddColor(pearlescent);
        boatType.AddWater(swimmingPool);
        boatType.AddFlag(medium);
        boatType.AddAnchor(hook);
    }
}
