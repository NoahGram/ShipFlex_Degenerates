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

    public void addWheel (BoatAssembly boatCreate, ArrayList<BoatType> types, int i) {
        System.out.printf("%n%n%n%n" + types.get(i).getName() + " | Wheel %n----------------------%n");
        for (int j = 0; j < boatCreate.boatList.getBoatTypes().get(i).getWheelTypes().size(); j++) {
            System.out.println("- " + boatCreate.boatList.getBoatTypes().get(i).getWheelTypes().get(j).getName());
        }
        System.out.print("\nAbove is a list of the pre-existing options for this boat.\n\nEnter the Price of the new part: ");
        double partPrice = input.nextDouble();
        input.nextLine();
        System.out.print("Enter the Name of the new part: ");
        String partName = input.nextLine();
        System.out.println("\nName: " + partName + "\nPrice: " + partPrice + "\n\nPress Enter to continue");
        input.nextLine();
        SteeringWheelType newPart = new SteeringWheelType(partName, boatCreate.boatList.getBoatTypes().get(i).getWheelTypes().size()+1, partPrice);
        boatCreate.boatList.getBoatTypes().get(i).AddSteeringWheel(newPart);
    }
}