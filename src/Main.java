public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        BoatAssembly boatCreate = new BoatAssembly();
        
        customer.setCustomerInfo();
        boatCreate.boatAssemble();
        customer.getCustomerInfo();
        boatCreate.boatOfferte(customer);
    }
}
