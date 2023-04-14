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

    public void addColor(BoatAssembly boatCreate, ArrayList<BoatType> types, int i) {
        System.out.printf("%n%n%n%n" + types.get(i).getName() + " | Color %n----------------------%n");
        for (int j = 0; j < boatCreate.boatList.getBoatTypes().get(i).getColorTypes().size(); j++) {
            System.out.println("- " + boatCreate.boatList.getBoatTypes().get(i).getColorTypes().get(j).getName());
        }
        System.out.print("\nAbove is a list of the pre-existing options for this boat.\n\nEnter the Price of the new part: ");
        double partPrice = input.nextDouble();
        input.nextLine();
        System.out.print("Enter the Name of the new part: ");
        String partName = input.nextLine();
        System.out.println("\nName: " + partName + "\nPrice: " + partPrice + "\n\nPress Enter to continue");
        input.nextLine();
        ColorType newPart = new ColorType(partName, boatCreate.boatList.getBoatTypes().get(i).getColorTypes().size()+1, partPrice);
        boatCreate.boatList.getBoatTypes().get(i).AddColor(newPart);
    }
}