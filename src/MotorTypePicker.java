import java.util.ArrayList;
import java.util.Scanner;

class MotorTypePicker {
    Scanner input = new Scanner(System.in);

    public MotorType selectMotor(BoatType boatType) {
        ArrayList<MotorType> MotorTypes = boatType.getMotorTypes();

        while (true) {
            System.out.print("\n\n\n\n\n\nMotor\n----------------------\n");
            for (MotorType MotorType : MotorTypes) {
                System.out.printf(MotorType.getNumber() + " - " + MotorType.getName() + " $" + MotorType.getPrice() + " \n");
            }
            System.out.print("\nPick a Motor by entering the corresponding number shown on-screen\nYour input: ");
            int chosenMotorType;
            chosenMotorType = input.nextInt();

            if (chosenMotorType < 0 || chosenMotorType > MotorTypes.size()) {
                input.nextLine();
                System.out.printf("\nInvalid input. Please choose a number between 1 and %d.%nPress Enter to try again", MotorTypes.size());
                input.nextLine();
            } else {
                for (MotorType MotorType : MotorTypes) {
                    if (MotorType.getNumber() == (chosenMotorType)) {
                        return MotorType;
                    }
                }
            }
        }
    }

    public void addMotor(BoatAssembly boatCreate, ArrayList<BoatType> types, int i) {
        BoatType boatType = boatCreate.boatList.getBoatTypes().get(i);
        int typeSize = boatType.getMotorTypes().size();

        System.out.printf("%n%n%n%n%s | Motor %n----------------------%n", types.get(i).getName());
        for (int j = 0; j < typeSize; j++) {
            System.out.println("- " + boatType.getMotorTypes().get(j).getName());
        }

        System.out.print("\nAbove is a list of the pre-existing options for this boat.\n\nEnter the Price of the new part: ");
        double partPrice = input.nextDouble();
        input.nextLine();

        System.out.print("Enter the Name of the new part: ");
        String partName = input.nextLine();

        System.out.printf("\nName: %s%nPrice: %s%n%nPress Enter to continue%n", partName, partPrice);
        input.nextLine();

        int nextMotorTypeId = typeSize + 1;
        MotorType newPart = new MotorType(partName, nextMotorTypeId, partPrice);
        boatType.AddMotor(newPart);
    }
}