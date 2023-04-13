import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        BoatAssembly boatCreate = new BoatAssembly();
        Scanner input = new Scanner(System.in);

        boolean bap;

        while (true) {
            System.out.printf("%n%n%n%nMain menu%n----------------------%n" +
                    " 1. Add Customer%n" +
                    " 2. View Customer%n" +
                    " 3. Boat Assembly Program%n" +
                    " 9. Add/Edit Options%n" +
                    "%nSelect an option by choosing the corresponding number%n" +
                    "Your input: ");
            switch (input.nextLine()) {
                case "1.", "1":
                    customer.setCustomerInfo();
                    break;
                case "2.", "2":
                    System.out.printf("%n%n%n%nCustomer View%n----------------------%n");
                    customer.getCustomerInfo();
                    System.out.printf("%nPress Enter to go back: ");
                    input.nextLine();
                    break;
                case "3.", "3":
                    bap = true;
                    while (bap) {
                        System.out.printf("%n%n%n%nBoat Assembly Program%n----------------------%n" +
                                " 1. Add boat%n" +
                                " 2. View/Edit boat%n" +
                                " 3. Finish%n" +
                                " 9. Back to Main Menu%n%n" +
                                "Your input: ");

                        switch (input.nextLine()) {
                            case "1", "1." -> boatCreate.boatAssemble();
                            case "2", "2." -> {
                            }
                            case "3", "3." -> {
                                try {
                                    System.out.printf("%n%n%n%n%n%n%n%nBoat Assembly Summary%n----------------------%n");
                                    customer.getCustomerInfo();
                                    System.out.println("");
                                    boatCreate.boatOfferte(customer);
                                } catch (Exception e) { System.out.printf("No created boat found.%n"); }
                                System.out.printf("----------------------%nFilled out as intended? %nYour input (Y/N): ");
                                if (input.nextLine().equalsIgnoreCase("y")) { System.exit(0); }
                            }
                            case "9", "9." -> bap = false;
                        }
                    }
                case "9.", "9":
                    break;
            }
        }
    }
}
