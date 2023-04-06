import java.util.ArrayList;
import java.util.Scanner;

class Wheel {
    Scanner input = new Scanner(System.in);
    private String material;
    private String type;
    private ArrayList<Wheel> wheels = new ArrayList<Wheel>();

    Wheel(){}
    public Wheel(String material, String type) {
        this.material = material;
        this.type = type;
    }

    public void selectWheel() {
        System.out.printf("\nEnter the material of the wheel: \n\n" +
            "$200,- Alloy \n" +
            "$ 75,- Steel \n" +
            "$115,- Chrome \n" +
            "$115,- Wood \n" +
            "Type 'done' to finish.\n\n" +
            "Your input: ");
        String wheelMaterial = input.nextLine();
        System.out.printf("\nEnter the type of the wheel: \n\n" +
            "$200,- Casted \n" +
            "$ 75,- Forged \n" +
            "$ 115,- Hand Crafted \n" +
            "Type 'done' to finish.\n\n" +
            "Your input: ");
        String wheelType = input.nextLine();
        setWheel(new Wheel(wheelMaterial, wheelType));
    }

    public String getMaterial() {
        return material;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Wheel> getWheel() {
        return wheels;
    }

    public void setWheel(Wheel wheel) {
        this.wheels.add(wheel);
    }
}