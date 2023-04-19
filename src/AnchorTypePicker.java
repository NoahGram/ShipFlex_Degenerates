import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class AnchorTypePicker {
    Scanner input = new Scanner(System.in);

    public AnchorType selectAnchor(BoatType boatType) {
        ArrayList<AnchorType> anchorTypes = boatType.getAnchorTypes();

        while (true) {
            System.out.printf("\n\n\n\n\n\nAnchor\n----------------------\n");
            for (AnchorType anchorType : anchorTypes) {
                System.out.printf(anchorType.getNumber() + " - " + anchorType.getName() + " $" + anchorType.getPrice() + " \n");
            }
            System.out.print("\nPick an Anchor by entering the corresponding number shown on-screen\nYour input: ");
            int chosenAnchorType;
            chosenAnchorType = input.nextInt();

            if (chosenAnchorType < 0 || chosenAnchorType > anchorTypes.size()) {
                input.nextLine();
                System.out.printf("\nInvalid input. Please choose a number between 1 and %d.%nPress Enter to try again", anchorTypes.size());
                input.nextLine();
            } else {
                for (AnchorType anchorType : anchorTypes) {
                    if (anchorType.getNumber() == (chosenAnchorType)) {
                        return anchorType;
                    }
                }
            }
        }
    }

    public void addAnchor(BoatAssembly boatCreate, ArrayList<BoatType> types, int i) {
        BoatType boatType = boatCreate.boatList.getBoatTypes().get(i);
        int typeSize = boatType.getAnchorTypes().size();

        System.out.printf("%n%n%n%n%s | Anchor %n----------------------%n", types.get(i).getName());
        for (int j = 0; j < typeSize; j++) {
            System.out.println("- " + boatType.getAnchorTypes().get(j).getName());
        }

        System.out.print("\nAbove is a list of the pre-existing options for this boat.\n\nEnter the Price of the new part: ");
        double partPrice = input.nextDouble();
        input.nextLine();

        System.out.print("Enter the Name of the new part: ");
        String partName = input.nextLine();

        System.out.printf("\nName: %s%nPrice: %s%n%nPress Enter to continue%n", partName, partPrice);
        input.nextLine();

        int nextAnchorTypeId = typeSize + 1;
        AnchorType newPart = new AnchorType(partName, nextAnchorTypeId, partPrice);
        boatType.AddAnchor(newPart);
    }
}