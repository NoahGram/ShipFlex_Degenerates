import java.util.ArrayList;
import java.util.Scanner;

class FlagSelector {
    Scanner input = new Scanner(System.in);

    public FlagType selectFlag(BoatType boatType) {
        System.out.printf("\nEnter the flag you want to add: \n\n");
        ArrayList<FlagType> flagTypes = boatType.getFlagTypes();

        for (FlagType flagType : flagTypes) {
            System.out.printf(flagType.getNumber() + " - " + flagType.getName() + " $" + flagType.getPrice() + " \n");
        }
        System.out.printf(
                "Type 'done' to finish.\n\n" +
                        "Your input: ");

        int chosenFlagType = input.nextInt();

        for (FlagType flagType : flagTypes) {
            if (flagType.getNumber() == (chosenFlagType)) {
                return flagType;
            }
        }

        return null;
    }
}