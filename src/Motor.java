import java.util.ArrayList;
import java.util.Scanner;


class MotorSelector {
    Scanner input = new Scanner(System.in);

    public MotorType selectMotor(BoatType boatType) {
        System.out.printf("\nEnter the motor you want to add: \n\n");
        ArrayList<MotorType> motorTypes = boatType.getMotorTypes();

        for (MotorType motorType : motorTypes) {
            System.out.printf(motorType.getName() + " $" + motorType.getPrice() + " \n");
        }
        System.out.printf(
            "Type 'done' to finish.\n\n" +
            "Your input: ");

        String chosenMotorType = input.nextLine();

        for (MotorType motorType : motorTypes) {
            if (motorType.getName().equalsIgnoreCase(chosenMotorType)) {
                return motorType;
            }
        }

        return null;
    }
}
/* 

class Motor  {
    private MotorType type;
    private String instrument;
    private ArrayList<Motor> motors = new ArrayList<Motor>();

    Motor() {}
    public Motor(MotorType type, String instrument) {
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
} */