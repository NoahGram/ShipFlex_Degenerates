class Boat {
    private String[] names = {"Speedboat", "Yacht", "Canoe", "Kayak", "Raft", "Lifeboat"};
    private String name;
    private double price;
    private String type;

    Boat() {}
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

    public String[] getNames() {
        return names;
    }
}