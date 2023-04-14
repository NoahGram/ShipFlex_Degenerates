import java.util.ArrayList;
import java.util.Scanner;

class ExhaustSelector {
    Scanner input = new Scanner(System.in);

    public ExhaustType selectExhaust(BoatType boatType) {
        System.out.printf("\nEnter the Exhaust you want to add: \n\n");
        ArrayList<ExhaustType> exhaustTypes = boatType.getExhaustTypes();

        for (ExhaustType exhaustType : exhaustTypes) {
            System.out.printf(exhaustType.getNumber() + " - " + exhaustType.getName() + " $" + exhaustType.getPrice() + " \n");
        }
        System.out.printf(
            "Type 'done' to finish.\n\n" +
            "Your input: ");

        int chosenExhaustType = input.nextInt();

        for (ExhaustType exhaustType : exhaustTypes) {
            if (exhaustType.getNumber() == (chosenExhaustType)) {
                return exhaustType;
            }
        }

        return null;
    }

    public void addExhaust(BoatAssembly boatCreate, ArrayList<BoatType> types, int i) {
        System.out.printf("%n%n%n%n" + types.get(i).getName() + " | Exhaust %n----------------------%n");
        for (int j = 0; j < boatCreate.boatList.getBoatTypes().get(i).getExhaustTypes().size(); j++) {
            System.out.println("- " + boatCreate.boatList.getBoatTypes().get(i).getExhaustTypes().get(j).getName());
        }
        System.out.print("\nAbove is a list of the pre-existing options for this boat.\n\nEnter the Price of the new part: ");
        double partPrice = input.nextDouble();
        input.nextLine();
        System.out.print("Enter the Name of the new part: ");
        String partName = input.nextLine();
        System.out.println("\nName: " + partName + "\nPrice: " + partPrice + "\n\nPress Enter to continue");
        input.nextLine();
        ExhaustType newPart = new ExhaustType(partName, boatCreate.boatList.getBoatTypes().get(i).getColorTypes().size()+1, partPrice);
        boatCreate.boatList.getBoatTypes().get(i).AddExhaust(newPart);
    }
}