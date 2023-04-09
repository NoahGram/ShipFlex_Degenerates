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

class ExhaustType extends BoatOption {
    ExhaustType(String name, double price) {
        super("Exhaust", name, price);
    }
}

class ColorType extends BoatOption {
    ColorType(String name, double price) {
        super("Color", name, price);
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
    private ArrayList<ExhaustType> exhaustTypes = new ArrayList<ExhaustType>();
    private ArrayList<ColorType> colorTypes = new ArrayList<ColorType>();
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

    public void AddExhaust(ExhaustType boatOption) {
        exhaustTypes.add(boatOption);
    }

    public void AddColor(ColorType boatOption) {
        colorTypes.add(boatOption);
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

    public ArrayList<SteeringWheelType> getWheelTypes() {
        return steeringWheelTypes;
    }

    public ArrayList<ExhaustType> getExhaustTypes() {
        return exhaustTypes;
    }

    public ArrayList<ColorType> getColorTypes() {
        return colorTypes;
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
    private ArrayList<BoatType> boatTypes = new ArrayList<BoatType>();

    BoatList() {
        MotorType toyota = new MotorType("Toyota", 200);
        MotorType bugatti = new MotorType("bugatti", 1200);
        MotorType ferrari = new MotorType("Ferrari Diesel", 800);
        MotorType ferrariElectric = new MotorType("Ferrari Electric", 1200);
        MotorType mercedes = new MotorType("Mercedes", 500);
        MotorType bmw = new MotorType("BMW", 5000);

        RoomType cabin = new RoomType("Cabin", 100);
        RoomType suite = new RoomType("Suite", 1100);
        RoomType stateroon = new RoomType("Stateroom", 1100);
        RoomType theater = new RoomType("Theater", 2150);
        RoomType kitchen = new RoomType("Kitchen", 3100);

        SteeringWheelType alloy = new SteeringWheelType("Alloy", 350);
        SteeringWheelType chrome = new SteeringWheelType("Chrome", 650);
        SteeringWheelType wood = new SteeringWheelType("Wood", 450);

        ExhaustType singlePipe = new ExhaustType("Single Pipe", 200);
        ExhaustType doublePipe = new ExhaustType("Double Pipe", 400);
        ExhaustType triplePipe = new ExhaustType("Triple Pipe", 800);

        ColorType white = new ColorType("White", 600);
        ColorType red = new ColorType("Red", 600);
        ColorType blue = new ColorType("Blue", 600);
        ColorType yellow = new ColorType("Yellow", 600);

        BoatType boatType = new BoatType("Speedboat", 35000, "Low");
        boatTypes.add(boatType);
        boatType.AddMotor(toyota);
        boatType.AddMotor(bugatti);
        boatType.AddMotor(ferrari);
        boatType.AddMotor(ferrariElectric);
        boatType.AddMotor(mercedes);
        boatType.AddSteeringWheel(alloy);
        boatType.AddSteeringWheel(chrome);
        boatType.AddSteeringWheel(wood);
        boatType.AddExhaust(singlePipe);
        boatType.AddExhaust(doublePipe);
        boatType.AddExhaust(triplePipe);
        boatType.AddColor(white);
        boatType.AddColor(red);
        boatType.AddColor(blue);
        boatType.AddColor(yellow);

        boatType = new BoatType("Yacht", 600000, "High");
        boatTypes.add(boatType);
        boatType.AddMotor(bugatti);
        boatType.AddMotor(ferrari);
        boatType.AddMotor(mercedes);
        boatType.AddMotor(bmw);
        boatType.AddSteeringWheel(alloy);
        boatType.AddSteeringWheel(chrome);
        boatType.AddSteeringWheel(wood);
        boatType.AddRoom(cabin);
        boatType.AddRoom(suite);
        boatType.AddRoom(stateroon);
        boatType.AddRoom(theater);
        boatType.AddRoom(kitchen);
        boatType.AddExhaust(singlePipe);
        boatType.AddExhaust(doublePipe);
        boatType.AddExhaust(triplePipe);
        boatType.AddColor(white);
        boatType.AddColor(red);
        boatType.AddColor(blue);
        boatType.AddColor(yellow);
    }

    public ArrayList<BoatType> getBoatTypes() {
        return boatTypes;
    }
}