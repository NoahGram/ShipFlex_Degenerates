import java.util.ArrayList;

class Exhaust {
    private String type;
    private String length;
    private ArrayList<Exhaust> exhausts = new ArrayList<Exhaust>();

    Exhaust() {}
    public Exhaust(String type, String length) {
        this.type = type;
        this.length = length;
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