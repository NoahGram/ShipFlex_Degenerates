import java.util.ArrayList;
import java.util.Scanner;

class Room {
    Scanner input = new Scanner(System.in);
    private String theme;
    private String type;
    private int amount;
    private ArrayList<Room> rooms = new ArrayList<Room>();
    
    Room() {}
    Room(int amount, String type, String theme) {
        this.amount = amount;
        this.type = type;
        this.theme = theme;
    }

    public void selectRoom() {
        System.out.printf("\nEnter the amount of rooms you want (Max 5): \n");
        amount = input.nextInt();
        input.nextLine();
        for(int i = 0; i<amount; i++) {
            System.out.println("\nEnter the room type your want \n\n" +
                "Cabin \n" +
                "Suite \n" +
                "Stateroom \n" +
                "Kitchen \n" +
                "Theater \n" +
                "Type 'done' to finish.\n\n" +
                "Your input: ");
            String roomType = input.nextLine();
            System.out.println("\nEnter the room theme \n\n" +
                "Classic \n" +
                "Deluxe \n" +
                "Luxury \n" +
                "Type 'done' to finish.\n\n" +
                "Your input: ");
            String RoomTheme = input.nextLine();
            setRooms(new Room(amount, roomType, RoomTheme));
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Room room) {
        this.rooms.add(room);
    }
}
