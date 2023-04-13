import java.util.ArrayList;
import java.util.Scanner;

class WaterSelector {
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
}