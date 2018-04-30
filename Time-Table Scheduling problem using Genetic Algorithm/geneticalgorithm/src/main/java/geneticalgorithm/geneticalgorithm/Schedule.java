package geneticalgorithm.geneticalgorithm;

import java.util.HashMap;



/**
 *
 * @author Jay
 */
public class Schedule {

    private final HashMap<Integer, Room> hashRooms;
    private final HashMap<Integer, Professor> hashProfessors;
    private final HashMap<Integer, Course> hashCourses;
    private final HashMap<Integer, Group> hashGroups;
    private final HashMap<Integer, TimeSlot> hashTimeSots;
    private Class classes[];
    private int numberOfClasses = 0;

    public Schedule() {
        this.hashRooms = new HashMap<Integer, Room>();
        this.hashProfessors = new HashMap<Integer, Professor>();
        this.hashCourses = new HashMap<Integer, Course>();
        this.hashGroups = new HashMap<Integer, Group>();
        this.hashTimeSots = new HashMap<Integer, TimeSlot>();
    }

    public Schedule(Schedule newTimeTable) {
        this.hashRooms = newTimeTable.getRooms();
        this.hashProfessors = newTimeTable.getHashProfessors();
        this.hashCourses = newTimeTable.getHashCourses();
        this.hashGroups = newTimeTable.getHashGroups();
        this.hashTimeSots = newTimeTable.getHashTimeSlots();
    }

    public HashMap<Integer, Professor> getHashProfessors() {
        return hashProfessors;
    }

    public HashMap<Integer, Course> getHashCourses() {
        return hashCourses;
    }

    public HashMap<Integer, Group> getHashGroups() {
        return hashGroups;
    }

    public HashMap<Integer, TimeSlot> getHashTimeSlots() {
        return hashTimeSots;
    }

    public void addRoom(int roomId, String roomName, int capacity) {
        this.hashRooms.put(roomId, new Room(roomId, roomName, capacity));
    }

    public void addProfessor(int professorId, String professorName) {
        this.hashProfessors.put(professorId, new Professor(professorId, professorName));
    }

    public void addCourse(int courseId, String courseCode, String courseName, int professorIds[]) {
        this.hashCourses.put(courseId, new Course(courseId, courseCode, courseName, professorIds));
    }

    public void addGroup(int groupId, int groupSize, int courseIds[]) {
        this.hashGroups.put(groupId, new Group(groupId, groupSize, courseIds));
        this.numberOfClasses = 0;
    }

    public void addTimeslot(int timeslotId, String timeslot) {
        this.hashTimeSots.put(timeslotId, new TimeSlot(timeslotId, timeslot));
    }

    public void createNewClasses(Individual individual) {
        Class classes[] = new Class[this.getNumberOfClasses()];
        int chromosome[] = individual.getChromosome();
        int chromosomePosition = 0;
        int classIndex = 0;
        for (Group group : this.getGroupArray()) {
            int courseIds[] = group.getCourseIDs();
            for (int courseId : courseIds) {
                classes[classIndex] = new Class(classIndex, group.getGroupID(), courseId);
                classes[classIndex].addTimeSlotID(chromosome[chromosomePosition]);
                chromosomePosition++;
                classes[classIndex].addRoomID(chromosome[chromosomePosition]);
                chromosomePosition++;
                classes[classIndex].addProfessor(chromosome[chromosomePosition]);
                chromosomePosition++;
                classIndex++;
            }
        }
        this.classes = classes;
    }

    public Room getRoom(int roomId) {
        if (!this.hashRooms.containsKey(roomId)) {
            System.out.println("Rooms doesn't contain key " + roomId);
        }
        return (Room) this.hashRooms.get(roomId);
    }

    public HashMap<Integer, Room> getRooms() {
        return this.hashRooms;
    }

    public Room getRandomRoom() {
        Object[] roomsArray = this.hashRooms.values().toArray();
        Room room = (Room) roomsArray[(int) (roomsArray.length * Math.random())];
        return room;
    }

    public Professor getProfessor(int professorId) {
        return (Professor) this.hashProfessors.get(professorId);
    }

    public Course getCourse(int courseId) {
        return (Course) this.hashCourses.get(courseId);
    }

    public int[] getGroupModules(int groupId) {
        Group group = (Group) this.hashGroups.get(groupId);
        return group.getCourseIDs();
    }

    public Group getGroup(int groupId) {
        return (Group) this.hashGroups.get(groupId);
    }

    public Group[] getGroupArray() {
        return (Group[]) this.hashGroups.values().toArray(new Group[this.hashGroups.size()]);
    }

    public TimeSlot getTimeslot(int timeslotId) {
        return (TimeSlot) this.hashTimeSots.get(timeslotId);
    }

    public TimeSlot getRandomTimeslot() {
        Object[] timeslotArray = this.hashTimeSots.values().toArray();
        TimeSlot timeslot = (TimeSlot) timeslotArray[(int) (timeslotArray.length * Math.random())];
        return timeslot;
    }

    public Class[] getClasses() {
        return this.classes;
    }

    public int getNumberOfClasses() {
        if (this.numberOfClasses > 0) {
            return this.numberOfClasses;
        }
        int numberOfClasses = 0;
        Group groups[] = (Group[]) this.hashGroups.values().toArray(new Group[this.hashGroups.size()]);
        for (Group group : groups) {
            numberOfClasses += group.getCourseIDs().length;
        }
        this.numberOfClasses = numberOfClasses;
        return this.numberOfClasses;
    }

    public int calculateClashes() {
        int numberOfClashes = 0;
        for (Class schedule1 : this.classes) {
            int roomCapacity = this.getRoom(schedule1.getRoomID()).getCapacity();
            int groupSize = this.getGroup(schedule1.getGroudID()).getGroupSize();
            if (roomCapacity < groupSize) {
                numberOfClashes++;
            }

            for (Class schedule2 : this.classes) {
                if (schedule1.getRoomID() == schedule2.getRoomID() && schedule1.getTimeSlotID() == schedule2.getTimeSlotID()
                        && schedule1.getClassID() != schedule2.getClassID()) {
                    numberOfClashes++;
                    break;
                }
            }
            for (Class schedule2 : this.classes) {
                if (schedule1.getProfessorID() == schedule2.getProfessorID() && schedule1.getTimeSlotID() == schedule2.getTimeSlotID()
                        && schedule1.getClassID() != schedule2.getClassID()) {

                    numberOfClashes++;
                    break;
                }
            }
        }
        return numberOfClashes;
    }
}
