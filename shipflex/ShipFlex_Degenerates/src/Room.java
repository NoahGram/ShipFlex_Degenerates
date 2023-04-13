import java.util.ArrayList;
import java.util.Scanner;

class RoomSelector {
    Scanner input = new Scanner(System.in);

    public RoomType selectRoom(BoatType boatType) {
        System.out.printf("\nEnter the Room you want to add: \n\n");
        ArrayList<RoomType> roomTypes = boatType.getRoomTypes();

        for (RoomType roomType : roomTypes) {
            System.out.printf(roomType.getNumber() + " - " + roomType.getName() + " $" + roomType.getPrice() + " \n");
        }
        System.out.printf(
            "Type 'done' to finish.\n\n" +
            "Your input: ");

        int chosenRoomType = input.nextInt();

        for (RoomType roomType : roomTypes) {
            if (roomType.getNumber() == (chosenRoomType)) {
                return roomType;
            }
        }

        return null;
    }
}