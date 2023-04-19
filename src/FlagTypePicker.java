import java.util.ArrayList;
import java.util.Scanner;

class FlagTypePicker {
    Scanner input = new Scanner(System.in);

    public FlagType selectFlag(BoatType boatType) {
        System.out.printf("\nEnter the flag you want to add: \n\n");
        ArrayList<FlagType> flagTypes = boatType.getFlagTypes();

        for (FlagType flagType : flagTypes) {
            System.out.printf(flagType.getNumber() + " - " + flagType.getName() + " $" + flagType.getPrice() + " \n");
        }
        System.out.printf(
                "Type 'done' to finish.\n\n" +
                        "Your input: ");

        int chosenFlagType = input.nextInt();

        for (FlagType flagType : flagTypes) {
            if (flagType.getNumber() == (chosenFlagType)) {
                return flagType;
            }
        }

        return null;
    }

    public void addFlag(BoatAssembly boatCreate, ArrayList<BoatType> types, int i) {
        BoatType boatType = boatCreate.boatList.getBoatTypes().get(i);
        int typeSize = boatType.getFlagTypes().size();

        System.out.printf("%n%n%n%n%s | Flag %n----------------------%n", types.get(i).getName());
        for (int j = 0; j < typeSize; j++) {
            System.out.println("- " + boatType.getFlagTypes().get(j).getName());
        }

        System.out.print("\nAbove is a list of the pre-existing options for this boat.\n\nEnter the Price of the new part: ");
        double partPrice = input.nextDouble();
        input.nextLine();

        System.out.print("Enter the Name of the new part: ");
        String partName = input.nextLine();

        System.out.printf("\nName: %s%nPrice: %s%n%nPress Enter to continue%n", partName, partPrice);
        input.nextLine();

        int nextFlagTypeId = typeSize + 1;
        FlagType newPart = new FlagType(partName, nextFlagTypeId, partPrice);
        boatType.AddFlag(newPart);
    }
}