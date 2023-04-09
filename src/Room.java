import java.util.ArrayList;
import java.util.Scanner;

class RoomSelector {
    Scanner input = new Scanner(System.in);

    public RoomType selectRoom(BoatType boatType) {
        System.out.printf("\nEnter the Room you want to add: \n\n");
        ArrayList<RoomType> roomTypes = boatType.getRoomTypes();

        for (RoomType roomType : roomTypes) {
            System.out.printf(roomType.getName() + " $" + roomType.getPrice() + " \n");
        }
        System.out.printf(
            "Type 'done' to finish.\n\n" +
            "Your input: ");

        String chosenRoomType = input.nextLine();

        for (RoomType roomType : roomTypes) {
            if (roomType.getName().equalsIgnoreCase(chosenRoomType)) {
                return roomType;
            }
        }

        return null;
    }
}