import java.util.ArrayList;
import java.util.Scanner;

class WheelTypePicker {
    Scanner input = new Scanner(System.in);

    public SteeringWheelType selectWheel(BoatType boatType) {
        ArrayList<SteeringWheelType> SteeringWheelTypes = boatType.getWheelTypes();

        while (true) {
            System.out.print("\n\n\n\n\n\nSteering Wheel\n----------------------\n");
            for (SteeringWheelType SteeringWheelType : SteeringWheelTypes) {
                System.out.printf(SteeringWheelType.getNumber() + " - " + SteeringWheelType.getName() + " $" + SteeringWheelType.getPrice() + " \n");
            }
            System.out.print("\nPick a Steering Wheel by entering the corresponding number shown on-screen\nYour input: ");
            int chosenSteeringWheelType;
            chosenSteeringWheelType = input.nextInt();

            if (chosenSteeringWheelType < 0 || chosenSteeringWheelType > SteeringWheelTypes.size()) {
                input.nextLine();
                System.out.printf("\nInvalid input. Please choose a number between 1 and %d.%nPress Enter to try again", SteeringWheelTypes.size());
                input.nextLine();
            } else {
                for (SteeringWheelType SteeringWheelType : SteeringWheelTypes) {
                    if (SteeringWheelType.getNumber() == (chosenSteeringWheelType)) {
                        return SteeringWheelType;
                    }
                }
            }
        }
    }

    public void addWheel (BoatAssembly boatCreate, ArrayList<BoatType> types, int i) {
        BoatType boatType = boatCreate.boatList.getBoatTypes().get(i);
        int typeSize = boatType.getWheelTypes().size();

        System.out.printf("%n%n%n%n%s | Wheel %n----------------------%n", types.get(i).getName());
        for (int j = 0; j < typeSize; j++) {
            System.out.println("- " + boatType.getWheelTypes().get(j).getName());
        }

        System.out.print("\nAbove is a list of the pre-existing options for this boat.\n\nEnter the Price of the new part: ");
        double partPrice = input.nextDouble();
        input.nextLine();

        System.out.print("Enter the Name of the new part: ");
        String partName = input.nextLine();

        System.out.printf("\nName: %s%nPrice: %s%n%nPress Enter to continue%n", partName, partPrice);
        input.nextLine();

        int nextWheelTypeId = typeSize + 1;
        SteeringWheelType newPart = new SteeringWheelType(partName, nextWheelTypeId, partPrice);
        boatType.AddSteeringWheel(newPart);
    }
}