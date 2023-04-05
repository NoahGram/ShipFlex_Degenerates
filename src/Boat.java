import java.util.ArrayList;

class Boat {
    private String name;
    private double price;
    private String type;
    private ArrayList<Boat> boats = new ArrayList<Boat>();

    Boat() {
        boats.add(new Boat("Speedboat", 35000, "Low"));
        boats.add(new Boat("Yacht", 600000, "High"));
        boats.add(new Boat("Canoe", 900, "Low"));
        boats.add(new Boat("Kayak", 420, "Low"));
        boats.add(new Boat("Raft", 150, "Low"));
        boats.add(new Boat("Lifeboat", 72000, "Medium"));
    }
    Boat(String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public void showInformation() {
        System.out.println("Selected Boat: " + getName() + "\nPrice: " + getPrice() + "\nType: " + getType());
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

    public ArrayList<Boat> getBoats() {
        return boats;
    }
}