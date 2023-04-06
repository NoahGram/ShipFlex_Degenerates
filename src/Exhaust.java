import java.util.ArrayList;
import java.util.Scanner;

class Exhaust {
    Scanner input = new Scanner(System.in);
    private String type;
    private String length;
    private ArrayList<Exhaust> exhausts = new ArrayList<Exhaust>();

    Exhaust() {}
    public Exhaust(String type, String length) {
        this.type = type;
        this.length = length;
    }

    public void selectExhaust() {
        System.out.printf("\nEnter the Type of the wheel: \n\n" +
            "$200,- Single Pipe \n" +
            "$115,- Dual Exhaust \n" +
            "$ 75,- Dual Rear Exhaust \n" +
            "$ 75,- Dual Side Exhaust \n" +
            "$ 75,- Triple Exhaust \n" +
            "Type 'done' to finish.\n\n" +
            "Your input: ");
        String exhaustType = input.nextLine();
        System.out.print("Enter the length of exhaust: ");
        String exhaustLength = input.nextLine();
        setExhaust(new Exhaust(exhaustType, exhaustLength));
    }

    public String getType() {
        return type;
    }

    public String getLength() {
        return length;
    }

    public ArrayList<Exhaust> getExhaust() {
        return exhausts;
    }

    public void setExhaust(Exhaust exhaust) {
        this.exhausts.add(exhaust);
    }
}