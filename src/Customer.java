import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Customer {
    Scanner input = new Scanner(System.in);
    private String name;
    private String businessName;
    private String type;
    private ArrayList<Customer> customer = new ArrayList<Customer>();
    private ArrayList<String> types = new ArrayList<>(Arrays.asList("Private", "Business"));

    Customer() {}
    Customer(String name, String businessName, String type) {
        this.name = name;
        this.businessName = businessName;
        this.type = type;
    }

    public void setCustomerInfo() {
        while (true) {
            System.out.printf("%n%n%n%n%n%n%nAdd Customer%n----------------------%n");
            System.out.printf("\nEnter Customer Type: %n");
            for (int i = 0; i < types.size(); i++) {
                System.out.println(i + 1 + ". " + types.get(i));
            }
            System.out.printf("%nSelect an option by choosing the corresponding number%nYour input: ");
            int customerType = Integer.parseInt(input.nextLine());
            System.out.println("\nEnter Customer Name: ");
            String customerName = input.nextLine();
            String businessName = "";
            if (customerType == 2) {
                System.out.println("\nEnter Business Name:");
                businessName = input.nextLine();
            }
            customer.add(new Customer(customerName, businessName, types.get(customerType - 1)));
            System.out.println("\n----------------------\nType: " + types.get(customerType - 1) + "\nName: " + customerName);
            if (businessName.isEmpty()) { }
            else { System.out.println("Business: " + businessName); }
            System.out.printf("%nIs this correct?%n");
            System.out.printf("%nYour input (Y/N): ");
            if (input.nextLine().equalsIgnoreCase("y")) { break; }
            else {
                customer.remove(customer.size() - 1);
                System.out.println("\nEntered data has been wiped. Press Enter to try again.");
                input.nextLine();
            }
        }
    }

    public void getCustomerInfo() {
        try {
            System.out.println("Customer: " + customer.get(0).name);
            if (customer.get(0).businessName.isEmpty()) {}
            else { System.out.println("Business Name: " + customer.get(0).businessName); }
            System.out.println("Customer Type: " + customer.get(0).getType());
        } catch (Exception e) {
            System.out.println("No customer found.");
        }
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
