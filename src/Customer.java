import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Customer {
    Scanner input = new Scanner(System.in);
    private String name;
    private String businessName;
    private String type;
    private static ArrayList<Customer> customer = new ArrayList<Customer>();
    private static ArrayList<String> types = new ArrayList<>(Arrays.asList("Private", "Business", "Government"));
    private static ArrayList<Double> discounts = new ArrayList<>(Arrays.asList(0.0, 0.1, 0.2));
    private static ArrayList<Boolean> isBusiness = new ArrayList<Boolean>(Arrays.asList(false, true, true));

    Customer() {}
    Customer(String name, String businessName, String type) {
        this.name = name;
        this.businessName = businessName;
        this.type = type;
    }

    public void setCustomerInfo2() {
        System.out.println("\nEnter Customer Name: ");
        String customerName = input.nextLine();
        this.name = customerName;
        System.out.println("\nEnter Business Name:");
        String businessName = input.nextLine();
        this.businessName = businessName;
        System.out.printf("\nEnter Customer Type: \n" +
            "Commercial\n" +
            "Private\n" +
            "Goverment\n" +
            "1 - Commercial\n" +
            "2 - Private\n" +
            "3 - Government\n" +
            "Your input: ");
        String customerType = input.nextLine();
        customer.add(new Customer(customerName, businessName, customerType));
        this.type = customerType;
    }

    public void setCustomerInfo() {
        while (true) {
            System.out.printf("%n%n%n%n%n%n%nAdd Customer%n----------------------%n");
            for (int i = 0; i < types.size(); i++) {
                System.out.println(i + 1 + ". " + types.get(i));
            }
            System.out.printf("%nSelect a Customer Type by choosing the corresponding number%nYour input: ");
            String customerType = input.nextLine();

            System.out.println("\nEnter the Customers Full Name: ");
            String customerName = input.nextLine();

            String businessName = "";
            if (isBusiness.get(Integer.parseInt(customerType)-1)) {
                System.out.println("\nEnter the Customers Business Name:");
                businessName = input.nextLine();
            }

            System.out.println("\n----------------------\nType: " + types.get(Integer.parseInt(customerType)-1) + "\nName: " + customerName + "\nApplied discount: " + discounts.get(Integer.parseInt(customerType)-1)*100 + "%\nIs a business: " + isBusiness.get(Integer.parseInt(customerType)-1));
            if (businessName.isEmpty()) { }
            else { System.out.println("Business: " + businessName); }
            System.out.printf("%nIs this correct?%n");
            System.out.printf("%nYour input (Y/N): ");
            if (input.nextLine().equalsIgnoreCase("y")) {
                customer.add(new Customer(customerName, businessName, customerType));
                break;
            }
            else {
                System.out.print("\nEntered data has been wiped. Press Enter to try again.");
                input.nextLine();
            }
        }
    }

    public ArrayList<String> getCustomerTypes() {
        return this.types;
    }

    public ArrayList<Double> getDiscounts() {
        return this.discounts;
    }

    public ArrayList<Boolean> getIsBusiness() {
        return isBusiness;
    }

    public void getCustomerInfo() {
        try {
            System.out.println("Customer: " + customer.get(customer.size()-1).name);
            if (customer.get(customer.size()-1).businessName.isEmpty()) {}
            else { System.out.println("Business Name: " + customer.get(customer.size()-1).businessName); }
            System.out.println("Customer Type: " + types.get(Integer.parseInt(customer.get(customer.size()-1).getType())-1));
        } catch (Exception e) {
            System.out.println("No customer(s) found.");
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

    public void setType(String type, Double discount, Boolean isBusiness) {
        this.types.add(type);
        this.discounts.add(discount);
        this.isBusiness.add(isBusiness);
    }

    public ArrayList<String> getTypes() {
        return this.types;
    }
}
