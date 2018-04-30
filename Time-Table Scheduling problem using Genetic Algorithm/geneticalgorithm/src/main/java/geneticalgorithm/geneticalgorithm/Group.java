package geneticalgorithm.geneticalgorithm;

/**
 *
 * @author Jay
 */
public class Group {
    private final int groupID;
    private final int groupSize;
    private final int courseIDs[];
    
    
    public Group(int groupID,int groupSize,int courseIDs[]){
    this.groupID = groupID;
    this.courseIDs = courseIDs;
    this.groupSize = groupSize;
    }

    public int getGroupID() {
        return groupID;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public int[] getCourseIDs() {
        return courseIDs;
    }
    
    
    
}

