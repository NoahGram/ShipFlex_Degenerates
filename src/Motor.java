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

    public void addMotor(BoatAssembly boatCreate, ArrayList<BoatType> types, int i) {
        System.out.printf("%n%n%n%n" + types.get(i).getName() + " | Motor %n----------------------%n");
        for (int j = 0; j < boatCreate.boatList.getBoatTypes().get(i).getMotorTypes().size(); j++) {
            System.out.println("- " + boatCreate.boatList.getBoatTypes().get(i).getMotorTypes().get(j).getName());
        }
        System.out.print("\nAbove is a list of the pre-existing options for this boat.\n\nEnter the Price of the new part: ");
        double partPrice = input.nextDouble();
        input.nextLine();
        System.out.print("Enter the Name of the new part: ");
        String partName = input.nextLine();
        System.out.println("\nName: " + partName + "\nPrice: " + partPrice + "\n\nPress Enter to continue");
        input.nextLine();
        MotorType newPart = new MotorType(partName, boatCreate.boatList.getBoatTypes().get(i).getMotorTypes().size()+1, partPrice);
        boatCreate.boatList.getBoatTypes().get(i).AddMotor(newPart);
    }
}