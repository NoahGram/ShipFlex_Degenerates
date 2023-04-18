import java.util.Scanner;

class BoatAssembly {
    Scanner input = new Scanner(System.in);

    BoatList boatList = new BoatList();
    RoomTypePicker room = new RoomTypePicker();
    WheelTypePicker wheel = new WheelTypePicker();
    ColorTypePicker color = new ColorTypePicker();
    ExhaustTypePicker exhaust = new ExhaustTypePicker();
    WaterPicker water = new WaterPicker();
    Customer customer = new Customer();
    MotorTypePicker motor = new MotorTypePicker();
    FlagTypePicker flagPicker = new FlagTypePicker();
    AnchorTypePicker anchor = new AnchorTypePicker();

    Boat selectedBoat = null;


    public void boatAssemble() {
        System.out.println("\n\n\n\n\n\nBoat Assembly Program\n----------------------");

        System.out.println("Available boats:");
        for (BoatType boatType : boatList.getBoatTypes()) {
            System.out.printf("%d - %s ($%.2f)\n", boatType.getNumber(), boatType.getName(), boatType.getPrice());
        }

        System.out.print("\nEnter the name of the boat you want to assemble: ");
        int boatTypeName = input.nextInt();
        input.nextLine();
        selectedBoat = null;
        for (BoatType boatType : boatList.getBoatTypes()) {
            if (boatType.getNumber() ==(boatTypeName)) {
                selectedBoat = new Boat(boatType);
                break;
            }
        }

        if (selectedBoat == null) {
            System.out.println("Invalid boat name.");
            return;
        }

        if (selectedBoat.getBoatType().getType() == "High") {

            boolean addParts = true;
            while (addParts) {
                System.out.print("\n\n\n\n\n" + selectedBoat.getBoatType().getName() + " | Boat Type = High\n----------------------\n" +
                    "1 - Room | Options: Type\n" +
                    "2 - Motor | Options: Engine,\n" +
                    "3 - Wheel | Options: Material\n" +
                    "4 - Color\n" +
                    "5 - Exhaust | Options: Type\n" +
                    "6 - Water Equipment | Options: Type\n\n" +
                    "7 - Flag | Options: Size\n" +
                    "8 - Anchor | Options: Type\n" +
                    "Add a part by entering the corresponding number shown on-screen. Enter 'done' to finish.\nYour input: ");
                String part = input.nextLine();
                switch (part.toLowerCase()) {
                    case "room", "Room", "1" -> selectedBoat.AddOption(room.selectRoom(selectedBoat.getBoatType()));
                    case "motor", "Motor", "2" -> selectedBoat.AddOption(motor.selectMotor(selectedBoat.getBoatType()));
                    case "wheel", "Wheel", "3" -> selectedBoat.AddOption(wheel.selectWheel(selectedBoat.getBoatType()));
                    case "color", "Color", "4" -> selectedBoat.AddOption(color.selectColor(selectedBoat.getBoatType()));
                    case "exhaust", "Exhaust", "5" -> selectedBoat.AddOption(exhaust.selectExhaust(selectedBoat.getBoatType()));
                    case "water", "Water", "6" -> selectedBoat.AddOption(water.selectWater(selectedBoat.getBoatType()));
                    case "flag", "Flag", "7" -> selectedBoat.AddOption(flagPicker.selectFlag(selectedBoat.getBoatType()));
                    case "anchor", "Anchor", "8" -> selectedBoat.AddOption(anchor.selectAnchor(selectedBoat.getBoatType()));
                    case "done", "Done" -> addParts = false;
                    default -> {System.out.println("Invalid part name. Try again by pressing enter."); input.nextLine(); }
                }
            }
        } else if(selectedBoat.getBoatType().getType() == "Medium") {
            System.out.println("Boat Type = Medium");
            boolean addParts = true;
            while (addParts) {
                System.out.print("\n\nEnter the name of the part you want to add \n\n" +
                    "1 - Room | Options: Type\n" +
                    "2 - Motor | Options: Engine,\n" +
                    "3 - Wheel | Options: Material\n" +
                    "4 - Color\n" +
                    "5 - Exhaust | Options: Type\n" +
                    "6 - Flag | Options: Size\n" +
                    "7 - Anchor | Options: Type\n" +
                    "Add a part by entering the corresponding number shown on-screen. Enter 'done' to finish.\nYour input: ");
                String part = input.nextLine();
                switch (part.toLowerCase()) {
                    case "room", "Room", "1" -> selectedBoat.AddOption(room.selectRoom(selectedBoat.getBoatType()));
                    case "motor", "Motor", "2" -> selectedBoat.AddOption(motor.selectMotor(selectedBoat.getBoatType()));
                    case "wheel", "Wheel", "3" -> selectedBoat.AddOption(wheel.selectWheel(selectedBoat.getBoatType()));
                    case "color", "Color", "4" -> selectedBoat.AddOption(color.selectColor(selectedBoat.getBoatType()));
                    case "exhaust", "Exhaust", "5" -> selectedBoat.AddOption(exhaust.selectExhaust(selectedBoat.getBoatType()));
                    case "flag", "Flag", "6" -> selectedBoat.AddOption(flagPicker.selectFlag(selectedBoat.getBoatType()));
                    case "anchor", "Anchor", "7" -> selectedBoat.AddOption(anchor.selectAnchor(selectedBoat.getBoatType()));
                    case "done", "Done" -> addParts = false;
                    default -> { System.out.print("Invalid part name. Try again by pressing enter."); input.nextLine(); }
                }
            }
        }else if(selectedBoat.getBoatType().getType() == "Low") {
            System.out.println("Boat Type = Low");
            boolean addParts = true;
            while (addParts) {
                System.out.printf("\n\nEnter the name of the part you want to add \n\n" +
                    "1 - Motor | Options: Engine,\n" +
                    "2 - Wheel | Options: Material\n" +
                    "3 - Color\n" +
                    "4 - Exhaust | Options: Type\n" +
                    "5 - Flag | Options: Size\n" +
                    "6 - Anchor | Options: Type\n" +
                    "Add a part by entering the corresponding number shown on-screen. Enter 'done' to finish.\nYour input: ");
                String part = input.nextLine();
                switch (part.toLowerCase()) {
                    case "motor", "Motor", "1" -> selectedBoat.AddOption(motor.selectMotor(selectedBoat.getBoatType()));
                    case "wheel", "Wheel", "2" -> selectedBoat.AddOption(wheel.selectWheel(selectedBoat.getBoatType()));
                    case "color", "Color", "3" -> selectedBoat.AddOption(color.selectColor(selectedBoat.getBoatType()));
                    case "exhaust", "Exhaust", "4" -> selectedBoat.AddOption(exhaust.selectExhaust(selectedBoat.getBoatType()));
                    case "flag", "Flag", "5" -> selectedBoat.AddOption(flagPicker.selectFlag(selectedBoat.getBoatType()));
                    case "anchor", "Anchor", "6" -> selectedBoat.AddOption(anchor.selectAnchor(selectedBoat.getBoatType()));
                    case "done", "Done" -> addParts = false;
                    default -> { System.out.println("Invalid part name. Try again by pressing enter."); input.nextLine();}
                }
            }
        }
    }

    public void boatOfferte(Customer customer) {
        selectedBoat.SetCustomer(customer);
        selectedBoat.boatSummary();
    }
}
