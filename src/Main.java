import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        BoatAssembly boatCreate = new BoatAssembly();
        Scanner input = new Scanner(System.in);
        BoatList boat = new BoatList();
        MotorTypePicker motor = new MotorTypePicker();
        WheelTypePicker wheel = new WheelTypePicker();
        ExhaustTypePicker exhaust = new ExhaustTypePicker();
        ColorTypePicker color = new ColorTypePicker();
        RoomTypePicker room = new RoomTypePicker();
        WaterPicker water = new WaterPicker();
        FlagTypePicker flag = new FlagTypePicker();
        AnchorTypePicker anchor = new AnchorTypePicker();

        while (true) {
            printMainMenu();
            switch (input.nextLine()) {
                case "1.", "1" -> customer.setCustomerInfo();
                case "2.", "2" -> viewCustomer(customer, input);
                case "3.", "3" -> boatAssemblyProgram(customer, boatCreate, input);
                case "9.", "9" -> {
                    printAddOptions();
                    switch (input.nextInt()) {
                        case 1 -> addNewOption(boatCreate, input, boat, motor, wheel, exhaust, color, room, water, flag, anchor);
                        case 2 -> addNewCustomer(customer, input);
                    }
                }
            }
        }
    }

    private static void printAddOptions() {
        System.out.printf("%n%n%n%nAdd Options%n----------------------%n" +
                " 1. Add option to existing boat" + "%n 2. Add new customer type" +
                "%n%nSelect an option by choosing the corresponding number%nYour input: ");
    }

    private static void printMainMenu() {
        System.out.printf("%n%n%n%nMain menu%n----------------------%n" +
                " 1. Add Customer%n" + " 2. View Customer%n" + " 3. Boat Assembly Program%n" + " 9. Add Options%n" +
                "%nSelect an option by choosing the corresponding number%n" +
                "Your input: ");
    }

    public static void addNewCustomer(Customer customer, Scanner input) {
        while (true) {
            System.out.printf("%n%n%n%nAdd New Customer Type%n----------------------%n");
            input.nextLine();
            System.out.print("Input the name of the new Customer Type: ");
            String newTypeName = input.nextLine();
            System.out.print("Input the discount amount of the new Customer Type (in percentage): ");
            Double newTypeDiscount = input.nextDouble();
            input.nextLine();
            System.out.print("Input if the new Customer Type is a business (true/false): ");
            Boolean newTypeIsBusiness = input.nextBoolean();
            input.nextLine();
            System.out.printf("%nName: %s%nDiscount: %s%nIs a Business: %s%n%n", newTypeName, newTypeDiscount, newTypeIsBusiness);
            System.out.print("Is this correct?\nYour input (Y/N/break): ");
            String confirmation = input.nextLine();

            if (confirmation.equalsIgnoreCase("y")) {
                customer.setType(newTypeName, newTypeDiscount/100, newTypeIsBusiness);
                break;
            } else if (confirmation.equalsIgnoreCase("break")) {
                break;
            } else {
                System.out.println("Entered data has been wiped. Press Enter to try again.");
                input.nextLine();
            }

        }
    }

    private static void addNewOption(BoatAssembly boatCreate, Scanner input, BoatList boat, MotorTypePicker motor, WheelTypePicker wheel, ExhaustTypePicker exhaust, ColorTypePicker color, RoomTypePicker room, WaterPicker water, FlagTypePicker flag, AnchorTypePicker anchor) {
        System.out.printf("%n%n%n%nAdd Option to Existing Boat%n----------------------%n");

        ArrayList<BoatType> types = boat.getBoatTypes();

        for (int i = 0; i < types.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, types.get(i).getName());
        }

        System.out.print("\n\nSelect an option by choosing the corresponding number\nYour input: ");
        int chosenBoat = input.nextInt() - 1;

        selectOption(types, chosenBoat);
        int chosenType = input.nextInt();

        switch (chosenType) {
            case 1 -> motor.addMotor(boatCreate, types, chosenBoat);
            case 2 -> wheel.addWheel(boatCreate, types, chosenBoat);
            case 3 -> color.addColor(boatCreate, types, chosenBoat);
            case 4 -> exhaust.addExhaust(boatCreate, types, chosenBoat);
            case 5 -> flag.addFlag(boatCreate, types, chosenBoat);
            case 6 -> anchor.addAnchor(boatCreate, types, chosenBoat);
            case 7 -> room.addRoom(boatCreate, types, chosenBoat);
            case 8 -> water.addWater(boatCreate, types, chosenBoat);
        }
    }

    private static void viewCustomer(Customer customer, Scanner input) {
        System.out.printf("%n%n%n%nCustomer View%n----------------------%n");
        customer.getCustomerInfo();
        System.out.printf("%nPress Enter to go back: ");
        input.nextLine();
    }

    private static void boatAssemblyProgram(Customer customer, BoatAssembly boatCreate, Scanner input) {
        boolean bap;
        bap = true;
        while (bap) {
            System.out.printf("%n%n%n%nBoat Assembly Program%n----------------------%n" +
                    " 1. Add boat%n" + " 2. View Boat%n" + " 3. Finish%n" + " 9. Back to Main Menu%n%n" +
                    "Your input: ");
            switch (input.nextLine()) {
                case "1", "1." -> boatCreate.boatAssemble();
                case "2", "2." -> viewBoat(customer, boatCreate, input);
                case "3", "3." -> getSummary(customer, boatCreate, input);
                case "9", "9." -> bap = false;
            }
        }
    }

    private static void getSummary(Customer customer, BoatAssembly boatCreate, Scanner input) {
        System.out.println("\n\nBoat Assembly Summary\n----------------------");
        customer.getCustomerInfo();
        System.out.println("");
        boatCreate.boatOfferte(customer);

        System.out.printf("%n----------------------\nFilled out as intended? (Y/N): ");
        if (input.nextLine().equalsIgnoreCase("y")) {
            System.exit(0);
        }
    }

    private static void viewBoat(Customer customer, BoatAssembly boatCreate, Scanner input) {
        System.out.printf("%n%n%n%nView Boat%n----------------------%n");
        boatCreate.boatOfferte(customer);
        System.out.printf("%n----------------------%n%nPress Enter to continue");
        input.nextLine();
    }

    private static void selectOption(ArrayList<BoatType> types, int chosenBoat) {
        String[] options = {"Motor", "Wheel", "Color", "Exhaust", "Flag", "Anchor"};
        String boatType = types.get(chosenBoat).getType().toLowerCase();
        if (boatType.equalsIgnoreCase("medium") || boatType.equalsIgnoreCase("high")) {
            options = Arrays.copyOf(options, options.length + 1);
            options[options.length - 1] = "Room";
        }
        if (boatType.equalsIgnoreCase("high")) {
            options = Arrays.copyOf(options, options.length + 1);
            options[options.length - 1] = "Water Equipment";
        }

        System.out.printf("%n%n%n%n%s%n----------------------%n", types.get(chosenBoat).getName());
        for (int j = 0; j < options.length; j++) {
            System.out.printf("%2d. %s%n", j + 1, options[j]);
        }
        System.out.printf("%nSelect an option by choosing the corresponding number%nYour input: ");
    }
}