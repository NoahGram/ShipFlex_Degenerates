import java.util.ArrayList;
import java.util.Scanner;

class Room {
    Scanner input = new Scanner(System.in);
    private String theme;
    private String type;
    private int amount;
    private ArrayList<Room> rooms = new ArrayList<Room>();
    
    Room() {
        rooms.add(new Room("Cabin", "Normal"));
        rooms.add(new Room("Suite", "Normal"));
        rooms.add(new Room("Stateroom", "Normal"));
    }
    Room(String theme, String type) {
        this.theme = theme;
        this.type = type;
    }

    public void selectRoom() {
        System.out.printf("\nEnter the amount of rooms you want (Max 5): \n");
        amount = input.nextInt();
        for(int i = 0; i<amount; i++) {
            System.out.printf("\nEnter the room type your want \n\n" +
                "$200,- Toyato \n" +
                "$ 75,- Ferrari \n" +
                "$115,- Bugatti \n" +
                "$115,- Mercedis \n" +
                "Type 'done' to finish.\n\n" +
                "Your input: ");
            String roomType = input.nextLine();
            System.out.printf("\nEnter the motor you want to add \n\n" +
                "$200,- Toyato \n" +
                "$ 75,- Ferrari \n" +
                "$115,- Bugatti \n" +
                "$115,- Mercedis \n" +
                "Type 'done' to finish.\n\n" +
                "Your input: ");
            String RoomTheme = input.nextLine();
            setRooms(new Room(roomType, RoomTheme));
        }
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Room room) {
        this.rooms.add(room);
    }
}
