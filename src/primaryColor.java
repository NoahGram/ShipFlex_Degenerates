import java.util.ArrayList;
import java.util.Scanner;

class primaryColor {
    Scanner input = new Scanner(System.in);
    private String color;
    private ArrayList<primaryColor> colors = new ArrayList<primaryColor>();

    primaryColor(){}
    public primaryColor(String color) {
        this.color = color;
    }

    public void selectColor() {
        System.out.printf("\nEnter the primary color:");
        String primaryColor = input.nextLine();
        setPrimaryColor(new primaryColor(primaryColor));
    }

    public String getColor() {
        return color;
    }

    public ArrayList<primaryColor> getPrimaryColor() {
        return colors;
    }

    public void setPrimaryColor(primaryColor color) {
        this.colors.add(color);
    }
}