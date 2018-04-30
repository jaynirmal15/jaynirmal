package geneticalgorithm.geneticalgorithm;


/**
 *
 * @author Jay
 */
public class TimeSlot {
    private final int timeSlotID;
    private final String time;
    
    public TimeSlot(int timeSlotID,String timeSlot)
    {
    this.timeSlotID =timeSlotID;
    this.time = timeSlot;
    }

    public int getTimeSlotID() {
        return timeSlotID;
    }

    public String getTimeSlot() {
        return time;
    }
    
    
    
}