import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class MyTest {
    //Create a new customer instance and check if it works.
    @Test
    void testCustomerTypes() {
        Customer customer = new Customer();
        String actual = customer.getTypes().get(0);
        String expected = "Private";
        assertEquals(expected, actual);
    }

    //Selects a boat and tests it with the expected result.
    @Test
    void testBoatPicker() {
        Boat boat = null;
        BoatList boatList = new BoatList();
        int boatTypeName = 11; // Use a boat type number that exists in the BoatList
        for (BoatType boatType : boatList.getBoatTypes()) {
            if (boatType.getNumber() == boatTypeName) {
                boat = new Boat(boatType);
                break;
            }
        }
    
        assertNotNull(boat); // Verify that a boat was found
        String expected = "Aquarius Yacht";
        String actual = boat.getBoatType().getName();
        assertEquals(expected, actual);
    }

    //Tests to see if you can create a boattype instance without errors.
    @Test
    void CreateBoatAssemblyWithCustomerIsSucces() {
        assertDoesNotThrow(() -> {
            BoatType boatType = new BoatType("Test", 1, 0, "Slow");
            BoatAssembly boatAssembly = new BoatAssembly();
            boatAssembly.selectedBoat = new Boat(boatType);
            boatAssembly.boatOfferte(new Customer());
        });
    }

    //Tests to see of you can combine boatOptions to a boattype
    @Test
    void CreateNewBoat() {
        assertDoesNotThrow(() -> {
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
        });
    }
}
