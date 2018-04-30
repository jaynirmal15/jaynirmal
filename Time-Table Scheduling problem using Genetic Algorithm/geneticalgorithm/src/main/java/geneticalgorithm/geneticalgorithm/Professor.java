package geneticalgorithm.geneticalgorithm;

/**
 *
 * @author Jay
 */
public class Professor {
    
    private final int  professorID;
    private final String professorName;
    
    
    public Professor(int professorID,String professorName){
    this.professorID = professorID;
    this.professorName = professorName;
    }

    public int getProfessorID() {
        return professorID;
    }

    public String getProfessorName() {
        return professorName;
    }
    
}
