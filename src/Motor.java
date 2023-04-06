import java.util.ArrayList;
import java.util.Scanner;

class Motor {
    Scanner input = new Scanner(System.in);
    private String type;
    private String instrument;
    private ArrayList<Motor> motors = new ArrayList<Motor>();

    Motor() {}
    public Motor(String type, String instrument) {
        this.type = type;
        this.instrument = instrument;
    }

    public void selectMotor() {
        System.out.printf("\nEnter the motor you want to add \n\n" +
            "$200,- Toyato \n" +
            "$ 75,- Ferrari \n" +
            "$115,- Bugatti \n" +
            "$115,- Mercedis \n" +
            "Type 'done' to finish.\n\n" +
            "Your input: ");
        String motorType = input.nextLine();
        System.out.printf("\nEnter the Engine Type of the motor: \n\n" +
            "$200,- Diesel \n" +
            "$ 75,- Hybrid \n" +
            "$115,- Electric \n" +
            "Type 'done' to finish.\n\n" +
            "Your input: ");

        String motorInstrument = input.nextLine();
        setMotor(new Motor(motorType, motorInstrument));
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