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
        for (BoatType boatType : boatList.getBoatTypes()) {
            System.out.printf("%d - %s ($%.2f)\n", boatType.getNumber(), boatType.getName(), boatType.getPrice());
        }
        System.out.print("\nPick a Boat by entering the corresponding number shown on-screen\nYour input: ");
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
                System.out.print("\n\n\n\n\n" + selectedBoat.getBoatType().getName() + " | Boat Type = " + selectedBoat.getBoatType().getType() + "\n----------------------\n");
                System.out.print("1 - Room | Options: Type\n" +
                    "2 - Motor | Options: Engine\n" +
                    "3 - Wheel | Options: Material\n" +
                    "4 - Color\n" +
                    "5 - Exhaust | Options: Type\n" +
                    "6 - Water Equipment | Options: Type\n" +
                    "7 - Flag | Options: Size\n" +
                    "8 - Anchor | Options: Type\n\n" +
                    "Add a part by entering the corresponding number shown on-screen.\nEnter 'done' to finish. Your input: ");
                String part = input.nextLine();
                switch (part.toLowerCase()) {
                    case "room", "1" -> selectedBoat.AddOption(room.selectRoom(selectedBoat.getBoatType()));
                    case "motor", "2" -> selectedBoat.AddOption(motor.selectMotor(selectedBoat.getBoatType()));
                    case "wheel", "3" -> selectedBoat.AddOption(wheel.selectWheel(selectedBoat.getBoatType()));
                    case "color", "4" -> selectedBoat.AddOption(color.selectColor(selectedBoat.getBoatType()));
                    case "exhaust", "5" -> selectedBoat.AddOption(exhaust.selectExhaust(selectedBoat.getBoatType()));
                    case "water", "6" -> selectedBoat.AddOption(water.selectWater(selectedBoat.getBoatType()));
                    case "flag", "7" -> selectedBoat.AddOption(flagPicker.selectFlag(selectedBoat.getBoatType()));
                    case "anchor", "8" -> selectedBoat.AddOption(anchor.selectAnchor(selectedBoat.getBoatType()));
                    case "done" -> addParts = false;
                    default -> {System.out.println("Invalid part name. Try again by pressing enter."); input.nextLine(); }
                }
            }
        } else if(selectedBoat.getBoatType().getType() == "Medium") {
            boolean addParts = true;
            while (addParts) {
                System.out.print("\n\n\n\n\n" + selectedBoat.getBoatType().getName() + " | Boat Type = " + selectedBoat.getBoatType().getType() + "\n----------------------\n");
                System.out.print("1 - Room | Options: Type\n" +
                    "2 - Motor | Options: Engine\n" +
                    "3 - Wheel | Options: Material\n" +
                    "4 - Color\n" +
                    "5 - Exhaust | Options: Type\n" +
                    "6 - Flag | Options: Size\n" +
                    "7 - Anchor | Options: Type\n\n" +
                    "Add a part by entering the corresponding number shown on-screen. Enter 'done' to finish.\nYour input: ");
                String part = input.nextLine();
                switch (part.toLowerCase()) {
                    case "room", "1" -> selectedBoat.AddOption(room.selectRoom(selectedBoat.getBoatType()));
                    case "motor", "2" -> selectedBoat.AddOption(motor.selectMotor(selectedBoat.getBoatType()));
                    case "wheel", "3" -> selectedBoat.AddOption(wheel.selectWheel(selectedBoat.getBoatType()));
                    case "color", "4" -> selectedBoat.AddOption(color.selectColor(selectedBoat.getBoatType()));
                    case "exhaust", "5" -> selectedBoat.AddOption(exhaust.selectExhaust(selectedBoat.getBoatType()));
                    case "flag", "6" -> selectedBoat.AddOption(flagPicker.selectFlag(selectedBoat.getBoatType()));
                    case "anchor", "7" -> selectedBoat.AddOption(anchor.selectAnchor(selectedBoat.getBoatType()));
                    case "done" -> addParts = false;
                    default -> { System.out.print("Invalid part name. Try again by pressing enter."); input.nextLine(); }
                }
            }
        }else if(selectedBoat.getBoatType().getType() == "Low") {
            boolean addParts = true;
            while (addParts) {
                System.out.print("\n\n\n\n\n" + selectedBoat.getBoatType().getName() + " | Boat Type = " + selectedBoat.getBoatType().getType() + "\n----------------------\n");
                System.out.print("1 - Motor | Options: Engine\n" +
                    "2 - Wheel | Options: Material\n" +
                    "3 - Color\n" +
                    "4 - Exhaust | Options: Type\n" +
                    "5 - Flag | Options: Size\n" +
                    "6 - Anchor | Options: Type\n\n" +
                    "Add a part by entering the corresponding number shown on-screen. Enter 'done' to finish.\nYour input: ");
                String part = input.nextLine();
                switch (part.toLowerCase()) {
                    case "motor", "1" -> selectedBoat.AddOption(motor.selectMotor(selectedBoat.getBoatType()));
                    case "wheel", "2" -> selectedBoat.AddOption(wheel.selectWheel(selectedBoat.getBoatType()));
                    case "color", "3" -> selectedBoat.AddOption(color.selectColor(selectedBoat.getBoatType()));
                    case "exhaust", "4" -> selectedBoat.AddOption(exhaust.selectExhaust(selectedBoat.getBoatType()));
                    case "flag", "5" -> selectedBoat.AddOption(flagPicker.selectFlag(selectedBoat.getBoatType()));
                    case "anchor", "6" -> selectedBoat.AddOption(anchor.selectAnchor(selectedBoat.getBoatType()));
                    case "done" -> addParts = false;
                    default -> { System.out.println("Invalid part name. Try again by pressing enter."); input.nextLine();}
                }
            }
        }
    }

    public void boatOfferte(Customer customer) {
        try { selectedBoat.SetCustomer(customer);
        } catch (Exception e) { System.out.println("Unable to assign a Customer to a Boat!"); }
        try {
            selectedBoat.boatSummary();
        } catch (Exception e) {
            System.out.print("No boat found!");
        }
    }
}
