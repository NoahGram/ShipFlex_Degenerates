import java.util.ArrayList;
import java.util.Scanner;

class ColorTypePicker {
    Scanner input = new Scanner(System.in);

    public ColorType selectColor(BoatType boatType) {
        ArrayList<ColorType> ColorTypes = boatType.getColorTypes();

        while (true) {
            System.out.printf("\n\n\n\n\n\nColor\n----------------------\n");
            for (ColorType ColorType : ColorTypes) {
                System.out.printf(ColorType.getNumber() + " - " + ColorType.getName() + " $" + ColorType.getPrice() + " \n");
            }
            System.out.print("\nPick a Color by entering the corresponding number shown on-screen\nYour input: ");
            int chosenColorType;
            chosenColorType = input.nextInt();

            if (chosenColorType < 0 || chosenColorType > ColorTypes.size()) {
                input.nextLine();
                System.out.printf("\nInvalid input. Please choose a number between 1 and %d.%nPress Enter to try again", ColorTypes.size());
                input.nextLine();
            } else {
                for (ColorType ColorType : ColorTypes) {
                    if (ColorType.getNumber() == (chosenColorType)) {
                        return ColorType;
                    }
                }
            }
        }
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