package geneticalgorithm.geneticalgorithm;


/**
 *
 * @author Jay
 */
public class Room {

    private final int id;
    private final String roomNumber;
    private final int roomCapacity;

    public Room(int roomID, String roomNumber, int capacity) {
        this.id = roomID;
        this.roomNumber = roomNumber;
        this.roomCapacity = capacity;
    }

    public int getRoomID() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return roomCapacity;
    }
}

