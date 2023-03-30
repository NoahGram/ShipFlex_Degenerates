public class Customer {
    private String name;
    private String businessName;
    private String type;

    Customer(String name, String businessName, String type) {
        this.name = name;
        this.businessName = businessName;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getBusinessName() {
        return businessName;
    }
}
