import java.util.ArrayList;
import java.util.Scanner;

class WheelSelector {
    Scanner input = new Scanner(System.in);

    public SteeringWheelType selectWheel(BoatType boatType) {
        System.out.printf("\nEnter the Steering Wheel you want to add: \n\n");
        ArrayList<SteeringWheelType> wheelTypes = boatType.getWheelTypes();

        for (SteeringWheelType wheelType : wheelTypes) {
            System.out.printf(wheelType.getNumber() + " - " + wheelType.getName() + " $" + wheelType.getPrice() + " \n");
        }
        System.out.printf(
            "Type 'done' to finish.\n\n" +
            "Your input: ");

        int chosenWheelType = input.nextInt();

        for (SteeringWheelType wheelType : wheelTypes) {
            if (wheelType.getNumber() == (chosenWheelType)) {
                return wheelType;
            }
        }

        return null;
    }
}