import java.lang.StackWalker.Option;
import java.lang.module.ModuleReader;
import java.util.ArrayList;

class BoatOption {
    private String optionType;
    private String name;
    private double price;

    BoatOption(String optionType, String name, double price) {
        this.optionType = optionType;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class MotorType extends BoatOption {
    MotorType(String name, double price) {
        super("Motor", name, price);
    }
}

class SteeringWheelType extends BoatOption {
    SteeringWheelType(String name, double price) {
        super("Wheel", name, price);
    }
}

class RoomType extends BoatOption {
    RoomType(String name, double price) {
        super("Room", name, price);
    }
}

class BoatType {
    private String name;
    private double price;
    private String type;

    private ArrayList<MotorType> motorTypes = new ArrayList<MotorType>();
    private ArrayList<SteeringWheelType> steeringWheelTypes = new ArrayList<SteeringWheelType>();
    private ArrayList<RoomType> roomTypes = new ArrayList<RoomType>();

    BoatType(String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public void AddMotor(MotorType boatOption) {
        motorTypes.add(boatOption);
    }

    public void AddSteeringWheel(SteeringWheelType boatOption) {
        steeringWheelTypes.add(boatOption);
    }

    public void AddRoom(RoomType roomType) {
        roomTypes.add(roomType);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public void showInformation() {
        System.out.println("Selected Boat: " + getName() + "\nPrice: " + getPrice() + "\nType: " + getType());
    }

    public ArrayList<MotorType> getMotorTypes() {
        return motorTypes;
    }

    public ArrayList<RoomType> getRoomTypes() {
        return roomTypes;
    }
}


class Boat {
    private BoatType boatType;
    private ArrayList<BoatOption> options = new ArrayList<BoatOption>();

    public Boat(BoatType boatType) {
        this.boatType = boatType;
    }

    public void AddOption(BoatOption option) {
        options.add(option);
    }

    public BoatType getBoatType() {
        return boatType;
    }

    public double getTotalCost() {
        double totalCost = 0.0;

        totalCost += boatType.getPrice();
        for (BoatOption boatOption : options) {
            totalCost += boatOption.getPrice();
        }

        return totalCost;
    }
}


class BoatList {
    private ArrayList<MotorType> motorTypes = new ArrayList<MotorType>();
    private ArrayList<BoatType> boatTypes = new ArrayList<BoatType>();

    BoatList() {
        MotorType toyota = new MotorType("Toyota", 200);
        MotorType bugatti = new MotorType("bugatti", 1200);
        MotorType ferrari = new MotorType("Ferrari Diesel", 800);
        MotorType ferrariElectric = new MotorType("Ferrari Electric", 1200);
        MotorType mercedes = new MotorType("Mercedes", 500);
        MotorType bmw = new MotorType("BMW", 5000);

        RoomType cabinClassic = new RoomType("Classic", 100);
        RoomType suiteLuxury = new RoomType("Luxury", 1100);

        BoatType boatType = new BoatType("Speedboat", 35000, "Low");
        boatTypes.add(boatType);
        boatType.AddMotor(toyota);
        boatType.AddMotor(bugatti);
        boatType.AddMotor(ferrari);
        boatType.AddMotor(ferrariElectric);
        boatType.AddMotor(mercedes);
        boatType.AddRoom(cabinClassic);

        boatType = new BoatType("Yacht", 600000, "High");
        boatTypes.add(boatType);
        boatType.AddMotor(bugatti);
        boatType.AddMotor(ferrari);
        boatType.AddMotor(mercedes);
        boatType.AddMotor(bmw);
        boatType.AddRoom(cabinClassic);
        boatType.AddRoom(suiteLuxury);

/*         boats.add(new BoatType("Canoe", 900, "Low"));
        boats.add(new BoatType("Kayak", 420, "Low"));
        boats.add(new BoatType("Raft", 150, "Low"));
        boats.add(new BoatType("Lifeboat", 72000, "Medium"));
 */    }

    public ArrayList<BoatType> getBoatTypes() {
        return boatTypes;
    }
}