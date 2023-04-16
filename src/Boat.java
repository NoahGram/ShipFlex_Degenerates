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
class FlagType extends BoatOption {
    FlagType(String name, int number, double price) {
        super("Flag", name, number, price);
    }
}

class AnchorType extends BoatOption {
    AnchorType(String name, int number, double price) {
        super("Anchor", name, number, price);
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
    private ArrayList<FlagType> flagTypes = new ArrayList<FlagType>();

    private ArrayList<AnchorType> anchorTypes = new ArrayList<AnchorType>();

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

    public void AddFlag(FlagType flagType) {
        flagTypes.add(flagType);
    }

    public void AddWater(WaterType waterType) {
        waterTypes.add(waterType);
    }

    public void AddAnchor(AnchorType anchorType) {
        anchorTypes.add(anchorType);
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

    public ArrayList<FlagType> getFlagTypes() {
        return flagTypes;
    }

    public ArrayList<AnchorType> getAnchorTypes() {return anchorTypes;}
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

        if (customerType.equals("Business") || customerType.equals("business") || customerType.equals("1")) {
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
        return totalCost;
    }
}

class BoatList {
    private ArrayList<BoatType> boatTypes = new ArrayList<BoatType>();

    BoatList() {
        MotorType AliExpress = new MotorType("AliExpress", 1, 120);
        MotorType Pod_Drive_Evo = new MotorType("Pod Drive Evo", 2, 1000);
        MotorType Mariner = new MotorType("Mariner", 3, 1500);
        MotorType Mitek = new MotorType("Mitek", 4, 3500);
        MotorType Honda = new MotorType("Honda", 5, 500);
        MotorType Yamaha = new MotorType("Yamaha", 6, 25000);

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
        ExhaustType EcoPipe = new ExhaustType("Eco Pipe", 4, 150);

        ColorType solid = new ColorType("Solid", 1, 600);
        ColorType pearlescent = new ColorType("Pearlescent", 2, 1000);
        ColorType metallic = new ColorType("Metallic", 3, 800);
        ColorType matte = new ColorType("Matte", 4, 700);
        ColorType metals = new ColorType("Metals", 5, 700);
        ColorType custom = new ColorType("Custom", 6, 1500);


        WaterType hottub = new WaterType("Hottub", 1, 1400);
        WaterType swimmingPool = new WaterType("Swimming Pool", 2, 4500);
        WaterType tippingBucket = new WaterType("Tipping Bucket", 6, 2350);
        WaterType jetski = new WaterType("Jetski", 4, 5225);
        WaterType jetskiElectric = new WaterType("Jetski Electric (Eco discount)", 5, 3225);
        WaterType diving_board = new WaterType("Diving board", 3, 500);

        FlagType small = new FlagType("Small", 1, 35);
        FlagType medium = new FlagType("Medium", 2, 60);
        FlagType big = new FlagType("Big", 3, 100);

        AnchorType fluke = new AnchorType("Fluke", 1, 50);
        AnchorType hook = new AnchorType("Hook", 2, 30);
        AnchorType plough = new AnchorType("Plough", 3, 55);
        AnchorType claw = new AnchorType("Claw", 4, 45);
        AnchorType scoop = new AnchorType("Scoop", 5, 55);


        BoatType boatType = new BoatType("Speedboat", 1, 15000, "Low");
        boatTypes.add(boatType);
        boatType.AddMotor(AliExpress);
        boatType.AddMotor(Pod_Drive_Evo);
        boatType.AddMotor(Mariner);
        boatType.AddMotor(Mitek);
        boatType.AddMotor(Honda);
        boatType.AddSteeringWheel(alloy);
        boatType.AddSteeringWheel(chrome);
        boatType.AddSteeringWheel(wood);
        boatType.AddExhaust(singlePipe);
        boatType.AddExhaust(doublePipe);
        boatType.AddExhaust(triplePipe);
        boatType.AddExhaust(EcoPipe);
        boatType.AddColor(solid);
        boatType.AddColor(pearlescent);
        boatType.AddColor(metallic);
        boatType.AddColor(matte);
        boatType.AddColor(metals);
        boatType.AddColor(custom);

        boatType.AddWater(diving_board);
        boatType.AddFlag(small);
        boatType.AddFlag(medium);
        boatType.AddAnchor(fluke);
        boatType.AddAnchor(hook);


        boatType = new BoatType("Lifeboat", 2, 13000, "Low");
        boatTypes.add(boatType);
        boatType.AddMotor(AliExpress);
        boatType.AddMotor(Pod_Drive_Evo);
        boatType.AddMotor(Mariner);
        boatType.AddMotor(Mitek);
        boatType.AddMotor(Honda);
        boatType.AddSteeringWheel(alloy);
        boatType.AddSteeringWheel(chrome);
        boatType.AddSteeringWheel(wood);
        boatType.AddExhaust(singlePipe);
        boatType.AddExhaust(doublePipe);
        boatType.AddExhaust(triplePipe);
        boatType.AddExhaust(EcoPipe);
        boatType.AddColor(solid);
        boatType.AddColor(pearlescent);
        boatType.AddColor(metallic);
        boatType.AddColor(matte);
        boatType.AddColor(metals);
        boatType.AddColor(custom);
        boatType.AddWater(diving_board);
        boatType.AddFlag(small);
        boatType.AddFlag(medium);
        boatType.AddAnchor(fluke);
        boatType.AddAnchor(hook);

        boatType = new BoatType("Gameboat", 3, 20000, "Low");
        boatTypes.add(boatType);
        boatType.AddMotor(AliExpress);
        boatType.AddMotor(Pod_Drive_Evo);
        boatType.AddMotor(Mariner);
        boatType.AddMotor(Mitek);
        boatType.AddMotor(Honda);
        boatType.AddSteeringWheel(alloy);
        boatType.AddSteeringWheel(chrome);
        boatType.AddSteeringWheel(wood);
        boatType.AddExhaust(singlePipe);
        boatType.AddExhaust(doublePipe);
        boatType.AddExhaust(triplePipe);
        boatType.AddExhaust(EcoPipe);
        boatType.AddColor(solid);
        boatType.AddColor(pearlescent);
        boatType.AddColor(metallic);
        boatType.AddColor(matte);
        boatType.AddColor(metals);
        boatType.AddColor(custom);
        boatType.AddWater(diving_board);
        boatType.AddFlag(small);
        boatType.AddFlag(medium);
        boatType.AddAnchor(fluke);
        boatType.AddAnchor(hook);

        boatType = new BoatType("Deckboat", 4, 10000, "Low");
        boatTypes.add(boatType);
        boatType.AddMotor(AliExpress);
        boatType.AddMotor(Pod_Drive_Evo);
        boatType.AddMotor(Mariner);
        boatType.AddMotor(Mitek);
        boatType.AddMotor(Honda);
        boatType.AddSteeringWheel(alloy);
        boatType.AddSteeringWheel(chrome);
        boatType.AddSteeringWheel(wood);
        boatType.AddExhaust(singlePipe);
        boatType.AddExhaust(doublePipe);
        boatType.AddExhaust(triplePipe);
        boatType.AddExhaust(EcoPipe);
        boatType.AddColor(solid);
        boatType.AddColor(pearlescent);
        boatType.AddColor(metallic);
        boatType.AddColor(matte);
        boatType.AddColor(metals);
        boatType.AddColor(custom);
        boatType.AddWater(diving_board);
        boatType.AddFlag(small);
        boatType.AddFlag(medium);
        boatType.AddAnchor(fluke);
        boatType.AddAnchor(hook);

        boatType = new BoatType("Sailboat (Eco discount)", 5, 25000, "Medium");
        boatTypes.add(boatType);
        boatType.AddMotor(AliExpress);
        boatType.AddMotor(Pod_Drive_Evo);
        boatType.AddMotor(Mariner);
        boatType.AddMotor(Mitek);
        boatType.AddMotor(Honda);
        boatType.AddSteeringWheel(alloy);
        boatType.AddSteeringWheel(chrome);
        boatType.AddSteeringWheel(wood);
        boatType.AddExhaust(singlePipe);
        boatType.AddExhaust(doublePipe);
        boatType.AddExhaust(triplePipe);
        boatType.AddExhaust(EcoPipe);
        boatType.AddColor(solid);
        boatType.AddColor(pearlescent);
        boatType.AddColor(metallic);
        boatType.AddColor(matte);
        boatType.AddColor(metals);
        boatType.AddColor(custom);
        boatType.AddRoom(kitchen);
        boatType.AddWater(diving_board);
        boatType.AddWater(jetski);
        boatType.AddWater(jetskiElectric);
        boatType.AddFlag(small);
        boatType.AddFlag(medium);
        boatType.AddFlag(big);
        boatType.AddAnchor(fluke);
        boatType.AddAnchor(hook);
        boatType.AddAnchor(plough);
        boatType.AddAnchor(claw);
        boatType.AddAnchor(scoop);

        boatType = new BoatType("Cruiser", 6, 45000, "Medium");
        boatTypes.add(boatType);
        boatType.AddMotor(AliExpress);
        boatType.AddMotor(Pod_Drive_Evo);
        boatType.AddMotor(Mariner);
        boatType.AddMotor(Mitek);
        boatType.AddMotor(Honda);
        boatType.AddSteeringWheel(alloy);
        boatType.AddSteeringWheel(chrome);
        boatType.AddSteeringWheel(wood);
        boatType.AddExhaust(singlePipe);
        boatType.AddExhaust(doublePipe);
        boatType.AddExhaust(triplePipe);
        boatType.AddExhaust(EcoPipe);
        boatType.AddColor(solid);
        boatType.AddColor(pearlescent);
        boatType.AddColor(metallic);
        boatType.AddColor(matte);
        boatType.AddColor(metals);
        boatType.AddColor(custom);
        boatType.AddRoom(kitchen);
        boatType.AddWater(diving_board);
        boatType.AddWater(jetski);
        boatType.AddWater(jetskiElectric);
        boatType.AddFlag(small);
        boatType.AddFlag(medium);
        boatType.AddFlag(big);
        boatType.AddAnchor(fluke);
        boatType.AddAnchor(hook);
        boatType.AddAnchor(plough);
        boatType.AddAnchor(claw);
        boatType.AddAnchor(scoop);

        boatType = new BoatType("Towboat", 7, 40000, "Medium");
        boatTypes.add(boatType);
        boatType.AddMotor(AliExpress);
        boatType.AddMotor(Pod_Drive_Evo);
        boatType.AddMotor(Mariner);
        boatType.AddMotor(Mitek);
        boatType.AddMotor(Honda);
        boatType.AddSteeringWheel(alloy);
        boatType.AddSteeringWheel(chrome);
        boatType.AddSteeringWheel(wood);
        boatType.AddExhaust(singlePipe);
        boatType.AddExhaust(doublePipe);
        boatType.AddExhaust(triplePipe);
        boatType.AddExhaust(EcoPipe);
        boatType.AddColor(solid);
        boatType.AddColor(pearlescent);
        boatType.AddColor(metallic);
        boatType.AddColor(matte);
        boatType.AddColor(metals);
        boatType.AddColor(custom);
        boatType.AddRoom(kitchen);
        boatType.AddWater(diving_board);
        boatType.AddWater(jetski);
        boatType.AddWater(jetskiElectric);
        boatType.AddFlag(small);
        boatType.AddFlag(medium);
        boatType.AddFlag(big);
        boatType.AddAnchor(fluke);
        boatType.AddAnchor(hook);
        boatType.AddAnchor(plough);
        boatType.AddAnchor(claw);
        boatType.AddAnchor(scoop);

        boatType = new BoatType("Tugboat", 8, 40000, "Medium");
        boatTypes.add(boatType);
        boatType.AddMotor(AliExpress);
        boatType.AddMotor(Pod_Drive_Evo);
        boatType.AddMotor(Mariner);
        boatType.AddMotor(Mitek);
        boatType.AddMotor(Honda);
        boatType.AddSteeringWheel(alloy);
        boatType.AddSteeringWheel(chrome);
        boatType.AddSteeringWheel(wood);
        boatType.AddExhaust(singlePipe);
        boatType.AddExhaust(doublePipe);
        boatType.AddExhaust(triplePipe);
        boatType.AddExhaust(EcoPipe);
        boatType.AddColor(solid);
        boatType.AddColor(pearlescent);
        boatType.AddColor(metallic);
        boatType.AddColor(matte);
        boatType.AddColor(metals);
        boatType.AddColor(custom);
        boatType.AddRoom(kitchen);
        boatType.AddWater(diving_board);
        boatType.AddWater(jetski);
        boatType.AddWater(jetskiElectric);
        boatType.AddFlag(small);
        boatType.AddFlag(medium);
        boatType.AddFlag(big);
        boatType.AddAnchor(fluke);
        boatType.AddAnchor(hook);
        boatType.AddAnchor(plough);
        boatType.AddAnchor(claw);
        boatType.AddAnchor(scoop);


        boatType = new BoatType("Orion Yacht", 9, 600000, "High");
        boatTypes.add(boatType);
        boatType.AddMotor(AliExpress);
        boatType.AddMotor(Pod_Drive_Evo);
        boatType.AddMotor(Mariner);
        boatType.AddMotor(Honda);
        boatType.AddMotor(Yamaha);
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
        boatType.AddExhaust(EcoPipe);
        boatType.AddColor(solid);
        boatType.AddColor(pearlescent);
        boatType.AddColor(metallic);
        boatType.AddColor(matte);
        boatType.AddColor(metals);
        boatType.AddColor(custom);
        boatType.AddWater(hottub);
        boatType.AddWater(swimmingPool);
        boatType.AddWater(diving_board);
        boatType.AddWater(jetski);
        boatType.AddWater(jetskiElectric);
        boatType.AddWater(tippingBucket);
        boatType.AddFlag(small);
        boatType.AddFlag(medium);
        boatType.AddFlag(big);
        boatType.AddAnchor(fluke);
        boatType.AddAnchor(hook);
        boatType.AddAnchor(plough);
        boatType.AddAnchor(claw);
        boatType.AddAnchor(scoop);



        boatType = new BoatType("Pisces Yacht", 10, 700000, "High");
        boatTypes.add(boatType);
        boatType.AddMotor(AliExpress);
        boatType.AddMotor(Pod_Drive_Evo);
        boatType.AddMotor(Mariner);
        boatType.AddMotor(Honda);
        boatType.AddMotor(Yamaha);
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
        boatType.AddExhaust(EcoPipe);
        boatType.AddColor(solid);
        boatType.AddColor(pearlescent);
        boatType.AddColor(metallic);
        boatType.AddColor(matte);
        boatType.AddColor(metals);
        boatType.AddColor(custom);
        boatType.AddWater(hottub);
        boatType.AddWater(swimmingPool);
        boatType.AddWater(diving_board);
        boatType.AddWater(jetski);
        boatType.AddWater(jetskiElectric);
        boatType.AddWater(tippingBucket);
        boatType.AddFlag(small);
        boatType.AddFlag(medium);
        boatType.AddFlag(big);
        boatType.AddAnchor(fluke);
        boatType.AddAnchor(hook);
        boatType.AddAnchor(plough);
        boatType.AddAnchor(claw);
        boatType.AddAnchor(scoop);

        boatType = new BoatType("Aquarius Yacht", 11, 800000, "High");
        boatTypes.add(boatType);
        boatType.AddMotor(AliExpress);
        boatType.AddMotor(Pod_Drive_Evo);
        boatType.AddMotor(Mariner);
        boatType.AddMotor(Honda);
        boatType.AddMotor(Yamaha);
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
        boatType.AddExhaust(EcoPipe);
        boatType.AddColor(solid);
        boatType.AddColor(pearlescent);
        boatType.AddColor(metallic);
        boatType.AddColor(matte);
        boatType.AddColor(metals);
        boatType.AddColor(custom);
        boatType.AddWater(hottub);
        boatType.AddWater(swimmingPool);
        boatType.AddWater(diving_board);
        boatType.AddWater(jetski);
        boatType.AddWater(jetskiElectric);
        boatType.AddWater(tippingBucket);
        boatType.AddFlag(small);
        boatType.AddFlag(medium);
        boatType.AddFlag(big);
        boatType.AddAnchor(fluke);
        boatType.AddAnchor(hook);
        boatType.AddAnchor(plough);
        boatType.AddAnchor(claw);
        boatType.AddAnchor(scoop);

        boatType = new BoatType("Super Galaxy Yacht", 12, 1200000, "High");
        boatTypes.add(boatType);
        boatType.AddMotor(AliExpress);
        boatType.AddMotor(Pod_Drive_Evo);
        boatType.AddMotor(Mariner);
        boatType.AddMotor(Honda);
        boatType.AddMotor(Yamaha);
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
        boatType.AddExhaust(EcoPipe);
        boatType.AddColor(solid);
        boatType.AddColor(pearlescent);
        boatType.AddColor(metallic);
        boatType.AddColor(matte);
        boatType.AddColor(metals);
        boatType.AddColor(custom);
        boatType.AddWater(hottub);
        boatType.AddWater(swimmingPool);
        boatType.AddWater(diving_board);
        boatType.AddWater(jetski);
        boatType.AddWater(jetskiElectric);
        boatType.AddWater(tippingBucket);
        boatType.AddFlag(small);
        boatType.AddFlag(medium);
        boatType.AddFlag(big);
        boatType.AddAnchor(fluke);
        boatType.AddAnchor(hook);
        boatType.AddAnchor(plough);
        boatType.AddAnchor(claw);
        boatType.AddAnchor(scoop);
    }

    public ArrayList<BoatType> getBoatTypes() {
        return boatTypes;
    }
}