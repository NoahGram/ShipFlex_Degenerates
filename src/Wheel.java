import java.util.ArrayList;

class Wheel {
    private String material;
    private String type;
    private ArrayList<Wheel> wheels = new ArrayList<Wheel>();

    Wheel(){}
    public Wheel(String material, String type) {
        this.material = material;
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Wheel> getWheel() {
        return wheels;
    }

    public void setWheel(Wheel wheel) {
        this.wheels.add(wheel);
    }
}