import java.util.ArrayList;
import java.util.Scanner;

class WheelTypePicker {
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