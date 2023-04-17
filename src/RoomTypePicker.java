import java.util.ArrayList;
import java.util.Scanner;

class RoomTypePicker {
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

    public void addRoom(BoatAssembly boatCreate, ArrayList<BoatType> types, int i) {
        BoatType boatType = boatCreate.boatList.getBoatTypes().get(i);
        int typeSize = boatType.getRoomTypes().size();

        System.out.printf("%n%n%n%n%s | Room %n----------------------%n", types.get(i).getName());
        for (int j = 0; j < typeSize; j++) {
            System.out.println("- " + boatType.getRoomTypes().get(j).getName());
        }

        System.out.print("\nAbove is a list of the pre-existing options for this boat.\n\nEnter the Price of the new part: ");
        double partPrice = input.nextDouble();
        input.nextLine();

        System.out.print("Enter the Name of the new part: ");
        String partName = input.nextLine();

        System.out.printf("\nName: %s%nPrice: %s%n%nPress Enter to continue%n", partName, partPrice);
        input.nextLine();

        int nextRoomTypeId = typeSize + 1;
        RoomType newPart = new RoomType(partName, nextRoomTypeId, partPrice);
        boatType.AddRoom(newPart);
    }
}