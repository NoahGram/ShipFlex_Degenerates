import java.util.ArrayList;
import java.util.Scanner;

class ColorSelector {
    Scanner input = new Scanner(System.in);

    public ColorType selectColor(BoatType boatType) {
        System.out.printf("\nEnter the Color you want to add: \n\n");
        ArrayList<ColorType> colorTypes = boatType.getColorTypes();

        for (ColorType colorType : colorTypes) {
            System.out.printf(colorType.getName() + " $" + colorType.getPrice() + " \n");
        }
        System.out.printf(
            "Type 'done' to finish.\n\n" +
            "Your input: ");

        String chosenColorType = input.nextLine();

        for (ColorType colorType : colorTypes) {
            if (colorType.getName().equalsIgnoreCase(chosenColorType)) {
                return colorType;
            }
        }

        return null;
    }
}