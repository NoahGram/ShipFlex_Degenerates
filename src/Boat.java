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
        System.out.println("\nApplied discount: " + customer.getDiscounts().get(Integer.parseInt(customer.getCustomer().get(customer.getCustomer().size()-1).getType())-1)*100 + "%");
        System.out.println("Total Price: $"+ getTotalCost());
    }

    public double getTotalCost() {
        double totalCost = 0.0;
        double discount = customer.getDiscounts().get(customer.getCustomerTypes().size()-1);

        totalCost += boatType.getPrice();
        for (BoatOption boatOption : options) {
            totalCost += boatOption.getPrice();
        }

        return totalCost - (totalCost * discount);
    }
}
