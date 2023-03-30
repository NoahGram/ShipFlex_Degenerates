import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Boat> myBoat = new ArrayList<Boat>();
        ArrayList<Motor> motors = new ArrayList<Motor>();
        ArrayList<Wheel> wheels = new ArrayList<Wheel>();
        ArrayList<primaryColor> primaryColors = new ArrayList<primaryColor>();
        ArrayList<secondaryColor> secondaryColors = new ArrayList<secondaryColor>();
        ArrayList<Exhaust> exhausts = new ArrayList<Exhaust>();

        ArrayList<Customer> customer = new ArrayList<Customer>();

        ArrayList<Boat> boatOptions = new ArrayList<Boat>();
        boatOptions.add(new Boat("Speedboat", 35000, "Low"));
        boatOptions.add(new Boat("Yacht", 600000, "High"));
        boatOptions.add(new Boat("Canoe", 900, "Low"));
        boatOptions.add(new Boat("Kayak", 420, "Low"));
        boatOptions.add(new Boat("Raft", 150, "Low"));
        boatOptions.add(new Boat("Lifeboat", 72000, "Medium"));

        System.out.println("Boat Assembly Program\n----------------------");
        System.out.println("%nEnter Customer Name %n");
        String customerName = input.nextLine();
        System.out.println("%nEnter Business Name %n");
        String businessName = input.nextLine();
        System.out.printf("%nEnter Customer Type %n%n" +
            "Commercial%n" +
            "Private%n" +
            "Goverment%n" +
            "Your input: ");
        String customerType = input.nextLine();
        customer.add(new Customer(customerName, businessName, customerType));

        System.out.println("Available boats:");
        for (Boat boat : boatOptions) {
            System.out.printf("%s ($%.2f)%n", boat.getName(), boat.getPrice());
        }

        System.out.print("\nEnter the name of the boat you want to assemble: ");
        String boatName = input.nextLine();
        Boat selectedBoat = null;
        for (Boat boat : boatOptions) {
            if (boat.getName().equalsIgnoreCase(boatName)) {
                selectedBoat = boat;
                break;
            }
        }

        if (selectedBoat == null) {
            System.out.println("Invalid boat name.");
            return;
        }

        // Ask user to add extra parts
        boolean addParts = true;
        while (addParts) {
            System.out.printf("%nEnter the name of the part you want to add %n%n" +
                    "- Motor | Options: Engine, Type%n" +
                    "- Wheel | Options: Material, Type%n" +
                    "- Primary Color%n" +
                    "- Secondary Color%n" +
                    "- Exhaust | Options: Type, Length%n%n" +
                    "Type 'done' to finish.%n%n" +
                    "Your input: ");
            String part = input.nextLine();
            switch (part.toLowerCase()) {
                case "motor":
                    System.out.printf("%nEnter the motor you want to add %n%n" +
                        "$200,- Toyato %n" +
                        "$ 75,- Ferrari %n" +
                        "$115,- Bugatti %n" +
                        "$115,- Mercedis %n" +
                        "Type 'done' to finish.%n%n" +
                        "Your input: ");
                    String motorType = input.nextLine();
                    System.out.printf("%nEnter the Engine Type of the motor: %n%n" +
                        "$200,- Diesel %n" +
                        "$ 75,- Hybrid %n" +
                        "$115,- Electric %n" +
                        "Type 'done' to finish.%n%n" +
                        "Your input: ");

                    String motorInstrument = input.nextLine();
                    motors.add(new Motor(motorType, motorInstrument));
                    break;
                case "wheel":
                    System.out.printf("%nEnter the material of the wheel: %n%n" +
                        "$200,- Alloy %n" +
                        "$ 75,- Steel %n" +
                        "$115,- Chrome %n" +
                        "$115,- Wood %n" +
                        "Type 'done' to finish.%n%n" +
                        "Your input: ");
                    String wheelMaterial = input.nextLine();
                    System.out.printf("%nEnter the type of the wheel: %n%n" +
                        "$200,- Casted %n" +
                        "$ 75,- Forged %n" +
                        "$ 115,- Hand Crafted %n" +
                        "Type 'done' to finish.%n%n" +
                        "Your input: ");
                    String wheelType = input.nextLine();
                    wheels.add(new Wheel(wheelMaterial, wheelType));
                    break;
                case "primarycolor", "primary", "primary color":
                    System.out.printf("%nEnter the primary color:");
                    String primaryColor = input.nextLine();
                    primaryColors.add(new primaryColor(primaryColor));
                    break;
                case "secondarycolor", "secondary", "secondary color":
                    System.out.print("Enter the secondary color: ");
                    String secondaryColor = input.nextLine();
                    secondaryColors.add(new secondaryColor(secondaryColor));
                    break;
                case "exhaust":
                    System.out.printf("%nEnter the Type of the wheel: %n%n" +
                        "$200,- Single Pipe %n" +
                        "$115,- Dual Exhaust %n" +
                        "$ 75,- Dual Rear Exhaust %n" +
                        "$ 75,- Dual Side Exhaust %n" +
                        "$ 75,- Triple Exhaust %n" +
                        "Type 'done' to finish.%n%n" +
                        "Your input: ");
                    String exhaustType = input.nextLine();
                    System.out.print("Enter the length of exhaust: ");
                    String exhaustLength = input.nextLine();
                    exhausts.add(new Exhaust(exhaustType, exhaustLength));
                    break;
                case "done":
                    addParts = false;
                    break;
                default:
                    System.out.println("Invalid part name. Try again by pressing enter.");
                    input.nextLine();
                    break;
            }
        }

        System.out.println("\nBoat assembly summary:");
        for (Customer klant : customer) {
            System.out.println("Customer: " + klant.getName() + ", Business Name: " + klant.getBusinessName() + "Customer Type: " + klant.getType());
        }
        System.out.printf("Boat: %s ($%.2f)%n", selectedBoat.getName(), selectedBoat.getPrice());
        double totalCost = selectedBoat.getPrice();
        for (Motor motor : motors) {
            totalCost+=200;
            System.out.println("Motor - Type: " + motor.getType() + ", Instrument: " + motor.getInstrument() + " ($200)");
        }
        for (Wheel wheel : wheels) {
            totalCost+=75;
            System.out.println("Wheel - Material: " + wheel.getMaterial() + ", Type: " + wheel.getType() + " ($75)");
        }
        for (primaryColor color : primaryColors) {
            totalCost+=115;
            System.out.println("Primary color: " + color.getColor() + " ($115)");
        }
        for (secondaryColor color : secondaryColors) {
            totalCost+=115;
            System.out.println("Secondary color: " + color.getColor() + " ($115)");
        }
        for (Exhaust exhaust : exhausts) {
            totalCost+=50;
            System.out.println("Exhaust - Type: " + exhaust.getType() + ", Length: " + exhaust.getLength() + " ($50)");
        }
        System.out.printf("Total Cost: $%.2f%n", totalCost);
    }

}