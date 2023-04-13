import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    Scanner input = new Scanner(System.in);
    private String name;
    private String businessName;
    private String type;
    private ArrayList<Customer> customer = new ArrayList<Customer>();

    Customer() {}
    Customer(String name, String businessName, String type) {
        this.name = name;
        this.businessName = businessName;
        this.type = type;
    }

    public void setCustomerInfo() {
        System.out.println("\nEnter Customer Name: ");
        String customerName = input.nextLine();
        this.name = customerName;
        System.out.println("\nEnter Business Name:");
        String businessName = input.nextLine();
        this.businessName = businessName;
        System.out.printf("\nEnter Customer Type: \n" +
            "1 - Commercial\n" +
            "2 - Private\n" +
            "3 - Government\n" +
            "Your input: ");
        String customerType = input.nextLine();
        this.type = customerType;
    }

    public void getCustomerInfo() {
        System.out.println("Customer: " + name + ", Business Name: " + businessName + ", Customer Type: " + type);
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

    public ArrayList<Customer> getCustomer() {
        return customer;
    }
}
