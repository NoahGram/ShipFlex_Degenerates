import java.util.ArrayList;
import java.util.Scanner;

class RoomTypePicker {
    Scanner input = new Scanner(System.in);

    public RoomType selectRoom(BoatType boatType) {
        ArrayList<RoomType> RoomTypes = boatType.getRoomTypes();

        while (true) {
            System.out.print("\n\n\n\n\n\nRoom\n----------------------\n");
            for (RoomType RoomType : RoomTypes) {
                System.out.printf(RoomType.getNumber() + " - " + RoomType.getName() + " $" + RoomType.getPrice() + " \n");
            }
            System.out.print("\nPick a Room by entering the corresponding number shown on-screen\nYour input: ");
            int chosenRoomType;
            chosenRoomType = input.nextInt();

            if (chosenRoomType < 0 || chosenRoomType > RoomTypes.size()) {
                input.nextLine();
                System.out.printf("\nInvalid input. Please choose a number between 1 and %d.%nPress Enter to try again", RoomTypes.size());
                input.nextLine();
            } else {
                for (RoomType RoomType : RoomTypes) {
                    if (RoomType.getNumber() == (chosenRoomType)) {
                        return RoomType;
                    }
                }
            }
        }
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