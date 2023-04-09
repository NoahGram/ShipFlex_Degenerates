import java.util.ArrayList;
import java.util.Scanner;

class MotorSelector {
    Scanner input = new Scanner(System.in);

    public MotorType selectMotor(BoatType boatType) {
        System.out.printf("\nEnter the motor you want to add: \n\n");
        ArrayList<MotorType> motorTypes = boatType.getMotorTypes();

        for (MotorType motorType : motorTypes) {
            System.out.printf(motorType.getName() + " $" + motorType.getPrice() + " \n");
        }
        System.out.printf(
            "Type 'done' to finish.\n\n" +
            "Your input: ");

        String chosenMotorType = input.nextLine();

        for (MotorType motorType : motorTypes) {
            if (motorType.getName().equalsIgnoreCase(chosenMotorType)) {
                return motorType;
            }
        }

        return null;
    }
}