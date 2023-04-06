import java.util.ArrayList;
import java.util.Scanner;

class BoatAssembly {
    Scanner input = new Scanner(System.in);
    Boat boats = new Boat();
    Motor motors = new Motor();
    Wheel wheels = new Wheel();
    primaryColor primaryColors = new primaryColor();
    secondaryColor secondaryColors = new secondaryColor();
    Exhaust exhausts = new Exhaust();
    Customer customer = new Customer();
    Boat selectedBoat = null;

    public void boatAssemble() {
        System.out.println("\nBoat Assembly Program\n----------------------");

        System.out.println("Available boats:");
        for (Boat boat : boats.getBoats()) {
            System.out.printf("%s ($%.2f)\n", boat.getName(), boat.getPrice());
        }

        System.out.print("\nEnter the name of the boat you want to assemble: ");
        String boatName = input.nextLine();
        selectedBoat = null;
        for (Boat boat : boats.getBoats()) {
            if (boat.getName().equalsIgnoreCase(boatName)) {
                selectedBoat = boat;
                break;
            }
        }

        if (selectedBoat == null) {
            System.out.println("Invalid boat name.");
            return;
        }

        if(selectedBoat.getType() == "High") {
            System.out.println("Boat Type = High");
            boolean addParts = true;
            while (addParts) {
                System.out.printf("\n\nEnter the name of the part you want to add \n\n" +
                        "- Motor | Options: Engine, Type\n" +
                        "- Wheel | Options: Material, Type\n" +
                        "- Primary Color\n" +
                        "- Secondary Color\n" +
                        "- Exhaust | Options: Type, Length\n\n" +
                        "Type 'done' to finish.\n\n" +
                        "Your input: ");
                String part = input.nextLine();
                switch (part.toLowerCase()) {
                    case "motor":
                        motors.selectMotor();
                        break;
                    case "wheel":
                        wheels.selectWheel();
                        break;
                    case "primarycolor", "primary", "primary color":
                        primaryColors.selectColor();
                        break;
                    case "secondarycolor", "secondary", "secondary color":
                        secondaryColors.selectColor();
                        break;
                    case "exhaust":
                        exhausts.selectExhaust();
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
        }else if(selectedBoat.getType() == "Medium") {
            System.out.println("Boat Type = Medium");
            boolean addParts = true;
            while (addParts) {
                System.out.printf("\n\nEnter the name of the part you want to add \n\n" +
                        "- Motor | Options: Engine, Type\n" +
                        "- Wheel | Options: Material, Type\n" +
                        "- Primary Color\n" +
                        "- Secondary Color\n" +
                        "- Exhaust | Options: Type, Length\n\n" +
                        "Type 'done' to finish.\n\n" +
                        "Your input: ");
                String part = input.nextLine();
                switch (part.toLowerCase()) {
                    case "motor":
                        motors.selectMotor();
                        break;
                    case "wheel":
                        wheels.selectWheel();
                        break;
                    case "primarycolor", "primary", "primary color":
                        primaryColors.selectColor();
                        break;
                    case "secondarycolor", "secondary", "secondary color":
                        secondaryColors.selectColor();
                        break;
                    case "exhaust":
                        exhausts.selectExhaust();
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
        }else if(selectedBoat.getType() == "Low") {
            System.out.println("Boat Type = Low");
            boolean addParts = true;
            while (addParts) {
                System.out.printf("\n\nEnter the name of the part you want to add \n\n" +
                        "- Motor | Options: Engine, Type\n" +
                        "- Wheel | Options: Material, Type\n" +
                        "- Primary Color\n" +
                        "- Secondary Color\n" +
                        "- Exhaust | Options: Type, Length\n\n" +
                        "Type 'done' to finish.\n\n" +
                        "Your input: ");
                String part = input.nextLine();
                switch (part.toLowerCase()) {
                    case "motor":
                        motors.selectMotor();
                        break;
                    case "wheel":
                        wheels.selectWheel();
                        break;
                    case "primarycolor", "primary", "primary color":
                        primaryColors.selectColor();
                        break;
                    case "secondarycolor", "secondary", "secondary color":
                        secondaryColors.selectColor();
                        break;
                    case "exhaust":
                        exhausts.selectExhaust();
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
        }

        
    }

    public void boatSummary() {
        System.out.println("\nBoat Assembly Summary:");
        customer.getCustomerInfo();
        System.out.printf("Boat: %s ($%.2f)%n", selectedBoat.getName(), selectedBoat.getPrice());
        double totalCost = selectedBoat.getPrice();
        for (Motor motor : motors.getMotor()) {
            totalCost+=200;
            System.out.println("Motor - Type: " + motor.getType() + ", Instrument: " + motor.getInstrument() + " ($200)");
        }
        for (Wheel wheel : wheels.getWheel()) {
            totalCost+=75;
            System.out.println("Wheel - Material: " + wheel.getMaterial() + ", Type: " + wheel.getType() + " ($75)");
        }
        for (primaryColor color : primaryColors.getPrimaryColor()) {
            totalCost+=115;
            System.out.println("Primary color: " + color.getColor() + " ($115)");
        }
        for (secondaryColor color : secondaryColors.getSecondaryColor()) {
            totalCost+=115;
            System.out.println("Secondary color: " + color.getColor() + " ($115)");
        }
        for (Exhaust exhaust : exhausts.getExhaust()) {
            totalCost+=50;
            System.out.println("Exhaust - Type: " + exhaust.getType() + ", Length: " + exhaust.getLength() + " ($50)");
        }
        System.out.printf("Total Cost: $%.2f%n", totalCost);
    }
}
