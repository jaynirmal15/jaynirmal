package geneticalgorithm.geneticalgorithm;

/**
*
* @author Jay
*/
public class Class {

   private final int classID;
   private final int groudID;
   private final int courseID;
   private int professorID;
   private int timeSlotID;
   private int roomID;

   public Class(int classID, int groudID, int courseID) {
       this.classID = classID;
       this.groudID = groudID;
       this.courseID = courseID;
   }

   

   public int getClassID() {
       return classID;
   }

   public int getGroudID() {
       return groudID;
   }

   public int getCourseID() {
       return courseID;
   }

   public int getProfessorID() {
       return professorID;
   }

   public int getTimeSlotID() {
       return timeSlotID;
   }

   public int getRoomID() {
       return roomID;
   }
   public void addProfessor(int professorID) {
       this.professorID = professorID;
   }
   public void addRoomID(int roomID) {
       this.roomID = roomID;
   }
   public void addTimeSlotID(int timeSlotID) {
       this.timeSlotID = timeSlotID;
   }
}

