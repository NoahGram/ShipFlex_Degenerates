import java.util.ArrayList;
import java.util.Scanner;

class Anchor {
    Scanner input = new Scanner(System.in);

    public AnchorType selectAnchor(BoatType boatType) {
        System.out.printf("\nEnter the anchor you want to add: \n\n");
        ArrayList<AnchorType> anchorTypes = boatType.getAnchorTypes();

        for (AnchorType anchorType : anchorTypes) {
            System.out.printf(anchorType.getNumber() + " - " + anchorType.getName() + " $" + anchorType.getPrice() + " \n");
        }
        System.out.printf(
                "Type 'done' to finish.\n\n" +
                        "Your input: ");

        int chosenAnchorType = input.nextInt();

        for (AnchorType anchorType : anchorTypes) {
            if (anchorType.getNumber() == (chosenAnchorType)) {
                return anchorType;
            }
        }

        return null;
    }
}