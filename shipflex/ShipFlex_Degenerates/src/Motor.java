import java.util.ArrayList;
import java.util.Scanner;

class MotorSelector {
    Scanner input = new Scanner(System.in);

    public MotorType selectMotor(BoatType boatType) {
        System.out.printf("\nEnter the motor you want to add: \n\n");
        ArrayList<MotorType> motorTypes = boatType.getMotorTypes();

        for (MotorType motorType : motorTypes) {
            System.out.printf(motorType.getNumber() + " - " + motorType.getName() + " $" + motorType.getPrice() + " \n");
        }
        System.out.printf(
            "Type 'done' to finish.\n\n" +
            "Your input: ");

        int chosenMotorType = input.nextInt();

        for (MotorType motorType : motorTypes) {
            if (motorType.getNumber() == (chosenMotorType)) {
                return motorType;
            }
        }

        return null;
    }
}