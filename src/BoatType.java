import java.util.ArrayList;

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