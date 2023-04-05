import java.util.ArrayList;

class secondaryColor {
    private String color;
    private ArrayList<secondaryColor> colors = new ArrayList<secondaryColor>();

    secondaryColor(){}
    public secondaryColor(String color) {
        this.color = color;
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