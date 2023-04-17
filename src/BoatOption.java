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