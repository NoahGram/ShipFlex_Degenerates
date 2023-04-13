import java.lang.StackWalker.Option;
import java.lang.module.ModuleReader;
import java.util.ArrayList;

abstract class BoatOption {
    private String optionType;
    private int number;
    private String name;
    private double price;

    BoatOption(String optionType, String name, int number, double price) {
        this.optionType = optionType;
        this.name = name;
        this.number = number;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }
}

class MotorType extends BoatOption {
    MotorType(String name, int number, double price) {
        super("Motor", name, number, price);
    }
}

class SteeringWheelType extends BoatOption {
    SteeringWheelType(String name, int number, double price) {
        super("Wheel", name, number, price);
    }
}

class ExhaustType extends BoatOption {
    ExhaustType(String name, int number, double price) {
        super("Exhaust", name, number, price);
    }
}

class ColorType extends BoatOption {
    ColorType(String name, int number, double price) {
        super("Color", name, number, price);
    }
}

class RoomType extends BoatOption {
    RoomType(String name, int number, double price) {
        super("Room", name, number, price);
    }
}

class WaterType extends BoatOption {
    WaterType(String name, int number, double price) {
        super("Water", name, number, price);
    }
}

class BoatType {
    private String name;
    private int number;
    private double price;
    private String type;

    private ArrayList<MotorType> motorTypes = new ArrayList<MotorType>();
    private ArrayList<SteeringWheelType> steeringWheelTypes = new ArrayList<SteeringWheelType>();
    private ArrayList<ExhaustType> exhaustTypes = new ArrayList<ExhaustType>();
    private ArrayList<ColorType> colorTypes = new ArrayList<ColorType>();
    private ArrayList<RoomType> roomTypes = new ArrayList<RoomType>();
    private ArrayList<WaterType> waterTypes = new ArrayList<WaterType>();

    BoatType(String name, int number, double price, String type) {
        this.name = name;
        this.number = number;
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

    public void AddWater(WaterType waterType) {
        waterTypes.add(waterType);
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
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

    public ArrayList<WaterType> getWaterTypes() {
        return waterTypes;
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

    public ArrayList<BoatOption> getOptions() {
        return options;
    }

    public void boatSummary(Customer customer) {
        System.out.println("Boat Type: "+ boatType.getName());
        System.out.println("Base Price: $"+ boatType.getPrice() +"\n");
        System.out.println("Selected Options:");
        for (BoatOption option : options) {
            System.out.println("- "+ option.getName()+ ": $"+ option.getPrice());
        }
        System.out.println("\nTotal Price: $"+ getTotalCost(customer));
    }

    public double getTotalCost(Customer customer) {
        double totalCost = 0.0;
        double discount = 0;

        totalCost += boatType.getPrice();
        for (BoatOption boatOption : options) {
            totalCost += boatOption.getPrice();
        }
        String customerType = customer.getCustomer().get(0).getType();

        if (customerType.equals("Commercial") || customerType.equals("commercial") || customerType.equals("1")) {
            discount = 0.1 * totalCost;
            return totalCost - discount;
        }else if(customerType.equals("Private") || customerType.equals("private") || customerType.equals("2")) {
            discount = 0.5 * totalCost;
            return totalCost - discount;
        }else if(customerType.equals("Government") || customerType.equals("government") || customerType.equals("3")) {
            discount = 0.2 * totalCost;
            return totalCost - discount;
        }else{
            System.out.println("Error No Customer Type Selected.\n");
        }
          System.out.println("Here!!!!");
        return totalCost;
    }
}

class BoatList {
    private ArrayList<BoatType> boatTypes = new ArrayList<BoatType>();

    BoatList() {
        MotorType toyota = new MotorType("Toyota", 1, 200);
        MotorType bugatti = new MotorType("bugatti", 2, 1200);
        MotorType ferrari = new MotorType("Ferrari Diesel", 3, 800);
        MotorType ferrariElectric = new MotorType("Ferrari Electric", 4, 1200);
        MotorType mercedes = new MotorType("Mercedes", 5, 500);
        MotorType bmw = new MotorType("BMW", 6, 5000);

        RoomType kitchen = new RoomType("Kitchen", 1, 3100);
        RoomType cabin = new RoomType("Cabin", 2, 100);
        RoomType suite = new RoomType("Suite", 3, 1100);
        RoomType stateroon = new RoomType("Stateroom", 4, 1100);
        RoomType theater = new RoomType("Theater", 5, 2150);

        SteeringWheelType alloy = new SteeringWheelType("Alloy", 1, 350);
        SteeringWheelType chrome = new SteeringWheelType("Chrome", 2, 650);
        SteeringWheelType wood = new SteeringWheelType("Wood", 3, 450);

        ExhaustType singlePipe = new ExhaustType("Single Pipe", 1, 200);
        ExhaustType doublePipe = new ExhaustType("Double Pipe", 2, 400);
        ExhaustType triplePipe = new ExhaustType("Triple Pipe", 3, 800);
        ExhaustType milieuPipe = new ExhaustType("Milieu Pipe", 4, 150);

        ColorType white = new ColorType("White", 1, 600);
        ColorType red = new ColorType("Red", 2, 600);
        ColorType blue = new ColorType("Blue", 3, 600);
        ColorType yellow = new ColorType("Yellow", 4, 600);

        WaterType hottub = new WaterType("Hottub", 1, 1400);
        WaterType swimmingPool = new WaterType("Swimming Pool", 2, 4500);
        WaterType tippingBucket = new WaterType("Tipping Bucket", 3, 2350);
        WaterType jetski = new WaterType("Jetski", 4, 5225);
        WaterType jetskiElectric = new WaterType("Jetski Electric", 5, 3225);

        BoatType boatType = new BoatType("Speedboat", 1, 35000, "Low");
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
        boatType.AddExhaust(milieuPipe);
        boatType.AddColor(white);
        boatType.AddColor(red);
        boatType.AddColor(blue);
        boatType.AddColor(yellow);

        boatType = new BoatType("Sailboat", 2, 35000, "Medium");
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
        boatType.AddExhaust(milieuPipe);
        boatType.AddColor(white);
        boatType.AddColor(red);
        boatType.AddColor(blue);
        boatType.AddColor(yellow);
        boatType.AddRoom(kitchen);

        boatType = new BoatType("Yacht", 3, 600000, "High");
        boatTypes.add(boatType);
        boatType.AddMotor(toyota);
        boatType.AddMotor(bugatti);
        boatType.AddMotor(ferrari);
        boatType.AddMotor(mercedes);
        boatType.AddMotor(bmw);
        boatType.AddSteeringWheel(alloy);
        boatType.AddSteeringWheel(chrome);
        boatType.AddSteeringWheel(wood);
        boatType.AddRoom(kitchen);
        boatType.AddRoom(cabin);
        boatType.AddRoom(suite);
        boatType.AddRoom(stateroon);
        boatType.AddRoom(theater);
        boatType.AddExhaust(singlePipe);
        boatType.AddExhaust(doublePipe);
        boatType.AddExhaust(triplePipe);
        boatType.AddExhaust(milieuPipe);
        boatType.AddColor(white);
        boatType.AddColor(red);
        boatType.AddColor(blue);
        boatType.AddColor(yellow);
        boatType.AddWater(hottub);
        boatType.AddWater(swimmingPool);
        boatType.AddWater(tippingBucket);
        boatType.AddWater(jetski);
        boatType.AddWater(jetskiElectric);
    }

    public ArrayList<BoatType> getBoatTypes() {
        return boatTypes;
    }
}