import java.util.ArrayList;
import java.util.Scanner;

class WheelSelector {
    Scanner input = new Scanner(System.in);

    public SteeringWheelType selectWheel(BoatType boatType) {
        System.out.printf("\nEnter the Steering Wheel you want to add: \n\n");
        ArrayList<SteeringWheelType> wheelTypes = boatType.getWheelTypes();

        for (SteeringWheelType wheelType : wheelTypes) {
            System.out.printf(wheelType.getName() + " $" + wheelType.getPrice() + " \n");
        }
        System.out.printf(
            "Type 'done' to finish.\n\n" +
            "Your input: ");

        String chosenWheelType = input.nextLine();

        for (SteeringWheelType wheelType : wheelTypes) {
            if (wheelType.getName().equalsIgnoreCase(chosenWheelType)) {
                return wheelType;
            }
        }

        return null;
    }
}