import java.util.ArrayList;

class Boat {
    private BoatType boatType;
    private Customer customer;
    private ArrayList<BoatOption> options = new ArrayList<BoatOption>();

    public Boat(BoatType boatType) {
        this.boatType = boatType;
    }

    public void SetCustomer(Customer customer) {
        this.customer = customer;
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

    public void boatSummary() {
        System.out.println("Boat Type: "+ boatType.getName());
        System.out.println("Base Price: $"+ boatType.getPrice() +"\n");
        System.out.println("Selected Options:");
        for (BoatOption option : options) {
            System.out.println("- "+ option.getName()+ ": $"+ option.getPrice());
        }
        System.out.println("\nTotal Price: $"+ getTotalCost());
    }

    public double getTotalCost() {
        double totalCost = 0.0;
        double discount = 0;

        totalCost += boatType.getPrice();
        for (BoatOption boatOption : options) {
            totalCost += boatOption.getPrice();
        }

        String customerType = customer.getType();
        if (customerType == null) {
            return totalCost;
        }
        else if (customerType.equals("Business") || customerType.equals("business") || customerType.equals("1")) {
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
