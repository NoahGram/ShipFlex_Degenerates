import java.util.ArrayList;
import java.util.Scanner;

class Water {
    Scanner input = new Scanner(System.in);

    public WaterType selectWater(BoatType boatType) {
        System.out.printf("\nEnter the Water Equipment do you want to add: \n\n");
        ArrayList<WaterType> waterTypes = boatType.getWaterTypes();

        for (WaterType waterType : waterTypes) {
            System.out.printf(waterType.getNumber() + " - " + waterType.getName() + " $" + waterType.getPrice() + " \n");
        }
        System.out.printf(
            "Type 'done' to finish.\n\n" +
            "Your input: ");

        int chosenWaterType = input.nextInt();

        for (WaterType waterType : waterTypes) {
            if (waterType.getNumber() == (chosenWaterType)) {
                return waterType;
            }
        }

        return null;
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