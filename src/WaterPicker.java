import java.util.ArrayList;
import java.util.Scanner;

class WaterPicker {
    Scanner input = new Scanner(System.in);

    public WaterType selectWater(BoatType boatType) {
        ArrayList<WaterType> WaterTypes = boatType.getWaterTypes();

        while (true) {
            System.out.print("\n\n\n\n\n\nWater Equipment\n----------------------\n");
            for (WaterType WaterType : WaterTypes) {
                System.out.printf(WaterType.getNumber() + " - " + WaterType.getName() + " $" + WaterType.getPrice() + " \n");
            }
            System.out.print("\nPick a Water Equipment by entering the corresponding number shown on-screen\nYour input: ");
            int chosenWaterType;
            chosenWaterType = input.nextInt();

            if (chosenWaterType < 0 || chosenWaterType > WaterTypes.size()) {
                input.nextLine();
                System.out.printf("\nInvalid input. Please choose a number between 1 and %d.%nPress Enter to try again", WaterTypes.size());
                input.nextLine();
            } else {
                for (WaterType WaterType : WaterTypes) {
                    if (WaterType.getNumber() == (chosenWaterType)) {
                        return WaterType;
                    }
                }
            }
        }
    }

    public void addWater(BoatAssembly boatCreate, ArrayList<BoatType> types, int i) {
        BoatType boatType = boatCreate.boatList.getBoatTypes().get(i);
        int typeSize = boatType.getWaterTypes().size();

        System.out.printf("%n%n%n%n%s | Water %n----------------------%n", types.get(i).getName());
        for (int j = 0; j < typeSize; j++) {
            System.out.println("- " + boatType.getWaterTypes().get(j).getName());
        }

        System.out.print("\nAbove is a list of the pre-existing options for this boat.\n\nEnter the Price of the new part: ");
        double partPrice = input.nextDouble();
        input.nextLine();

        System.out.print("Enter the Name of the new part: ");
        String partName = input.nextLine();

        System.out.printf("\nName: %s%nPrice: %s%n%nPress Enter to continue%n", partName, partPrice);
        input.nextLine();

        int nextWaterTypeId = typeSize + 1;
        WaterType newPart = new WaterType(partName, nextWaterTypeId, partPrice);
        boatType.AddWater(newPart);
    }
}