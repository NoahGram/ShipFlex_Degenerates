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
}