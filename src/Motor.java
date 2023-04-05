import java.util.ArrayList;

class Motor {
    private String type;
    private String instrument;
    private ArrayList<Motor> motors = new ArrayList<Motor>();

    Motor() {}
    public Motor(String type, String instrument) {
        this.type = type;
        this.instrument = instrument;
    }

    public String getType() {
        return type;
    }

    public String getInstrument() {
        return instrument;
    }

    public ArrayList<Motor> getMotor() {
        return motors;
    }

    public void setMotor(Motor motor) {
        this.motors.add(motor);
    }
}