import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*         Scanner input = new Scanner(System.in);
        Boat boats = new Boat();
        Motor motors = new Motor();
        Wheel wheels = new Wheel();
        primaryColor primaryColors = new primaryColor();
        secondaryColor secondaryColors = new secondaryColor();
        Exhaust exhausts = new Exhaust();
dsds*/
        Customer customer = new Customer();
        BoatAssembly boatCreate = new BoatAssembly();

        customer.setCustomerInfo();
        boatCreate.boatAssemble();
        boatCreate.boatSummary();
    }
}
