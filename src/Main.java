import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        BoatAssembly boatCreate = new BoatAssembly();
        Scanner input = new Scanner(System.in);
        BoatList boat = new BoatList();
        MotorSelector motor = new MotorSelector();
        WheelSelector wheel = new WheelSelector();
        ExhaustSelector exhaust = new ExhaustSelector();
        ColorSelector color = new ColorSelector();

        boolean bap;

        while (true) {
            System.out.printf("%n%n%n%nMain menu%n----------------------%n" +
                    " 1. Add Customer%n" + " 2. View Customer%n" + " 3. Boat Assembly Program%n" + " 9. Add Options%n" +
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
                                " 1. Add boat%n" + " 2. View/Edit boat%n" + " 3. Finish%n" + " 9. Back to Main Menu%n%n" +
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
                    break;
                case "9.", "9":
                    System.out.printf("%n%n%n%nAdd Options%n----------------------%n" +
                            " 1. Add option to existing boat" + "%n 2. Add new customer type" + "%n 3. Add new boat type" +
                            "%n%nSelect an option by choosing the corresponding number%nYour input: ");
                    switch (input.nextLine()) {
                        case "1":
                            System.out.printf("%n%n%n%nAdd Option to Existing Boat%n----------------------%n");
                            ArrayList<BoatType> types = boat.getBoatTypes();
                            int i = 1;
                            for (BoatType type : types) {
                                System.out.printf("%d. %s%n", i++, type.getName());
                            }
                            System.out.print("\n\nSelect an option by choosing the corresponding number\nYour input: ");
                            switch (input.nextInt()) {
                                case 1:
                                    System.out.printf("%n%n%n%n" + types.get(0).getName() + "%n----------------------%n" +
                                            " 1. Motor%n" + " 2. Wheel%n" + " 3. Color%n" + " 4. Exhaust%n%n" +
                                            "Select an option by choosing the corresponding number%nYour input: ");
                                    switch (input.nextInt()) {
                                        case 1:
                                            motor.addMotor(boatCreate, types, 0);
                                            break;
                                        case 2:
                                            wheel.addWheel(boatCreate, types, 0);
                                            break;
                                        case 3:
                                            color.addColor(boatCreate, types, 0);
                                            break;
                                        case 4:
                                            exhaust.addExhaust(boatCreate, types, 0);
                                            break;
                                    }
                                case 2:
                                case 3:
                            }
                            break;
                        case "2":
                            while (true) {
                                System.out.printf("%n%n%n%nAdd New Customer Type%n----------------------%n" +
                                        "Input the name of the new Customer Type: ");
                                customer.setType(input.nextLine());
                                System.out.println("Entered: " + customer.getTypes().get(customer.getTypes().size()-1));
                                System.out.printf("%nIs this correct?%n");
                                System.out.printf("%nYour input (Y/N): ");
                                if (input.nextLine().equalsIgnoreCase("y")) {
                                    break;
                                }
                                else {
                                    customer.getTypes().remove(customer.getTypes().size()-1);
                                    System.out.println("Entered data has been wiped. Press Enter to try again.");
                                    input.nextLine();
                                }
                            }
                        case "3":
                    }
                    input.nextLine();
                    break;
            }
        }
    }
}
