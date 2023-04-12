import java.util.ArrayList;
import java.util.Scanner;

class ColorSelector {
    Scanner input = new Scanner(System.in);

    public ColorType selectColor(BoatType boatType) {
        System.out.printf("\nEnter the Color you want to add: \n\n");
        ArrayList<ColorType> colorTypes = boatType.getColorTypes();

        for (ColorType colorType : colorTypes) {
            System.out.printf(colorType.getNumber() + " - " + colorType.getName() + " $" + colorType.getPrice() + " \n");
        }
        System.out.printf(
            "Type 'done' to finish.\n\n" +
            "Your input: ");

        int chosenColorType = input.nextInt();

        for (ColorType colorType : colorTypes) {
            if (colorType.getNumber() == (chosenColorType)) {
                return colorType;
            }
        }

        return null;
    }
}