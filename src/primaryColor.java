import java.util.ArrayList;

class primaryColor {
    private String color;
    private ArrayList<primaryColor> colors = new ArrayList<primaryColor>();

    primaryColor(){}
    public primaryColor(String color) {
        this.color = color;
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