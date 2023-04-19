import java.util.ArrayList;
import java.util.Scanner;

class FlagTypePicker {
    Scanner input = new Scanner(System.in);

    public FlagType selectFlag(BoatType boatType) {
        ArrayList<FlagType> FlagTypes = boatType.getFlagTypes();

        while (true) {
            System.out.print("\n\n\n\n\n\nFlag\n----------------------\n");
            for (FlagType FlagType : FlagTypes) {
                System.out.printf(FlagType.getNumber() + " - " + FlagType.getName() + " $" + FlagType.getPrice() + " \n");
            }
            System.out.print("\nPick a Flag by entering the corresponding number shown on-screen\nYour input: ");
            int chosenFlagType;
            chosenFlagType = input.nextInt();

            if (chosenFlagType < 0 || chosenFlagType > FlagTypes.size()) {
                input.nextLine();
                System.out.printf("\nInvalid input. Please choose a number between 1 and %d.%nPress Enter to try again", FlagTypes.size());
                input.nextLine();
            } else {
                for (FlagType FlagType : FlagTypes) {
                    if (FlagType.getNumber() == (chosenFlagType)) {
                        return FlagType;
                    }
                }
            }
        }
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