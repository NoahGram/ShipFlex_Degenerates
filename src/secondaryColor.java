import java.util.ArrayList;
import java.util.Scanner;

class secondaryColor {
    Scanner input = new Scanner(System.in);
    private String color;
    private ArrayList<secondaryColor> colors = new ArrayList<secondaryColor>();

    secondaryColor(){}
    public secondaryColor(String color) {
        this.color = color;
    }

    public void selectColor() {
        System.out.print("Enter the secondary color: ");
        String secondaryColor = input.nextLine();
        setSecondaryColor(new secondaryColor(secondaryColor));
    }

    public String getColor() {
        return color;
    }

    public ArrayList<secondaryColor> getSecondaryColor() {
        return colors;
    }

    public void setSecondaryColor(secondaryColor color) {
        this.colors.add(color);
    }
}