import java.util.ArrayList;
import java.util.Scanner;

class ExhaustTypePicker {
    Scanner input = new Scanner(System.in);

    public ExhaustType selectExhaust(BoatType boatType) {
        ArrayList<ExhaustType> ExhaustTypes = boatType.getExhaustTypes();

        while (true) {
            System.out.printf("\n\n\n\n\n\nExhaust\n----------------------\n");
            for (ExhaustType ExhaustType : ExhaustTypes) {
                System.out.printf(ExhaustType.getNumber() + " - " + ExhaustType.getName() + " $" + ExhaustType.getPrice() + " \n");
            }
            System.out.print("\nPick an Exhaust by entering the corresponding number shown on-screen\nYour input: ");
            int chosenExhaustType;
            chosenExhaustType = input.nextInt();

            if (chosenExhaustType < 0 || chosenExhaustType > ExhaustTypes.size()) {
                input.nextLine();
                System.out.printf("\nInvalid input. Please choose a number between 1 and %d.%nPress Enter to try again", ExhaustTypes.size());
                input.nextLine();
            } else {
                for (ExhaustType ExhaustType : ExhaustTypes) {
                    if (ExhaustType.getNumber() == (chosenExhaustType)) {
                        return ExhaustType;
                    }
                }
            }
        }
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
        ExhaustType newPart = new ExhaustType(partName, boatCreate.boatList.getBoatTypes().get(i).getExhaustTypes().size()+1, partPrice);
        boatCreate.boatList.getBoatTypes().get(i).AddExhaust(newPart);
    }
}