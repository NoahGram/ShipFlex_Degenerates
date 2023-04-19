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
        try {
            System.out.println("Boat Type: "+ boatType.getName());
            System.out.println("Base Price: $"+ boatType.getPrice() +"\n");
            System.out.println("Selected Options:");
            for (BoatOption option : options) {
                System.out.println("- "+ option.getName()+ ": $"+ option.getPrice());
            }
        } catch (Exception e) {
            System.out.println("No boat found!");
        }
        try {
            System.out.println("\nApplied discount: " + customer.getDiscounts().get(Integer.parseInt(customer.getCustomer().get(customer.getCustomer().size()-1).getType())-1)*100 + "%");
            System.out.printf("Total Price: $%.2f", getTotalCost());
        } catch (Exception e) {
            System.out.print("\nUnable to calculate a Total Price without a Customer!");
        }
    }

    public double getTotalCost() {
        double totalCost = 0.0;
        double discount = customer.getDiscounts().get(Integer.parseInt(customer.getCustomer().get(customer.getCustomer().size()-1).getType())-1);

        totalCost += boatType.getPrice();
        for (BoatOption boatOption : options) {
            totalCost += boatOption.getPrice();
        }

        return totalCost - (totalCost * discount);
    }
}
