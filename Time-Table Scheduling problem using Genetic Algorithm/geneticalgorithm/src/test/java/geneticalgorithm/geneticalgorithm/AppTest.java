package geneticalgorithm.geneticalgorithm;






import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void test3()
    {
        assertTrue( true );
    }
   //test case to check if the fitness is equal to one or not
	public void test1() {
		//one of the chromosome of bestfitindividual
	int[] chromosomeLength = new int[] {9,4,1,15,5,1,2,2,3,14,2,2,13,5,2,2,5,2,11,5,3,6,5,1,11,4,4,11,2,1,3,5,4,10,5,4,8,4,2,1,5,2,13,2,3,13,4,4,4,2,2,5,5,1,3,2,1,12,5,4};
		Individual ind = new Individual(chromosomeLength);
		
		Schedule sch =  new Schedule();
		sch.addRoom(1, "A1", 15);
		sch.addRoom(2, "B1", 30);
		sch.addRoom(4, "D1", 20);
		sch.addRoom(5, "F1", 25);

		// Set up timeslots
		sch.addTimeslot(1, "Mon 9:00 - 11:00");
		sch.addTimeslot(2, "Mon 11:00 - 13:00");
		sch.addTimeslot(3, "Mon 13:00 - 15:00");
		sch.addTimeslot(4, "Tue 9:00 - 11:00");
		sch.addTimeslot(5, "Tue 11:00 - 13:00");
		sch.addTimeslot(6, "Tue 13:00 - 15:00");
		sch.addTimeslot(7, "Wed 9:00 - 11:00");
		sch.addTimeslot(8, "Wed 11:00 - 13:00");
		sch.addTimeslot(9, "Wed 13:00 - 15:00");
		sch.addTimeslot(10, "Thu 9:00 - 11:00");
		sch.addTimeslot(11, "Thu 11:00 - 13:00");
		sch.addTimeslot(12, "Thu 13:00 - 15:00");
		sch.addTimeslot(13, "Fri 9:00 - 11:00");
		sch.addTimeslot(14, "Fri 11:00 - 13:00");
		sch.addTimeslot(15, "Fri 13:00 - 15:00");

		// Set up professors
		sch.addProfessor(1, "Dr P Smith");
		sch.addProfessor(2, "Mrs E Mitchell");
		sch.addProfessor(3, "Dr R Williams");
		sch.addProfessor(4, "Mr A Thompson");

		// Set up modules and define the professors that teach them
		sch.addCourse(1, "cs1", "Computer Science", new int[] { 1, 2 });
		sch.addCourse(2, "en1", "English", new int[] { 1, 3 });
		sch.addCourse(3, "ma1", "Maths", new int[] { 1, 2 });
		sch.addCourse(4, "ph1", "Physics", new int[] { 3, 4 });
		sch.addCourse(5, "hi1", "History", new int[] { 4 });
		sch.addCourse(6, "dr1", "Drama", new int[] { 1, 4 });

		// Set up student groups and the modules they take.
		sch.addGroup(1, 10, new int[] { 1, 3 });
		sch.addGroup(2, 30, new int[] { 2, 3 });
		sch.addGroup(3, 18, new int[] { 3 });
		sch.addGroup(4, 25, new int[] { 1 });
		sch.addGroup(5, 20, new int[] { 2, 3, 5 });
		sch.addGroup(6, 22, new int[] { 1, 4, 5 });
		sch.addGroup(7, 16, new int[] { 1, 3 });
		sch.addGroup(8, 18, new int[] { 2, 6 });
		sch.addGroup(9, 24, new int[] { 1, 6 });
		sch.addGroup(10, 25, new int[] { 3, 4 });
	
		GeneticAlgorithm ge = new GeneticAlgorithm(10, 0.4, 0.6, 2, 5);
		
		assertEquals(ge.calcFitness(ind, sch), 1.0);
		
		
		
		
	
	}
	//test case to check if the chromosome is being created or not
	public void test2() {
		Schedule sch =  new Schedule();
		sch.addRoom(1, "A1", 15);
		sch.addRoom(2, "B1", 30);
		sch.addRoom(4, "D1", 20);
		sch.addRoom(5, "F1", 25);

		// Set up timeslots
		sch.addTimeslot(1, "Mon 9:00 - 11:00");
		sch.addTimeslot(2, "Mon 11:00 - 13:00");
		sch.addTimeslot(3, "Mon 13:00 - 15:00");
		sch.addTimeslot(4, "Tue 9:00 - 11:00");
		sch.addTimeslot(5, "Tue 11:00 - 13:00");
		sch.addTimeslot(6, "Tue 13:00 - 15:00");
		sch.addTimeslot(7, "Wed 9:00 - 11:00");
		sch.addTimeslot(8, "Wed 11:00 - 13:00");
		sch.addTimeslot(9, "Wed 13:00 - 15:00");
		sch.addTimeslot(10, "Thu 9:00 - 11:00");
		sch.addTimeslot(11, "Thu 11:00 - 13:00");
		sch.addTimeslot(12, "Thu 13:00 - 15:00");
		sch.addTimeslot(13, "Fri 9:00 - 11:00");
		sch.addTimeslot(14, "Fri 11:00 - 13:00");
		sch.addTimeslot(15, "Fri 13:00 - 15:00");

		// Set up professors
		sch.addProfessor(1, "Dr P Smith");
		sch.addProfessor(2, "Mrs E Mitchell");
		sch.addProfessor(3, "Dr R Williams");
		sch.addProfessor(4, "Mr A Thompson");

		// Set up modules and define the professors that teach them
		sch.addCourse(1, "cs1", "Computer Science", new int[] { 1, 2 });
		sch.addCourse(2, "en1", "English", new int[] { 1, 3 });
		sch.addCourse(3, "ma1", "Maths", new int[] { 1, 2 });
		sch.addCourse(4, "ph1", "Physics", new int[] { 3, 4 });
		sch.addCourse(5, "hi1", "History", new int[] { 4 });
		sch.addCourse(6, "dr1", "Drama", new int[] { 1, 4 });

		// Set up student groups and the modules they take.
		sch.addGroup(1, 10, new int[] { 1, 3 });
		sch.addGroup(2, 30, new int[] { 2, 3 });
		sch.addGroup(3, 18, new int[] { 3 });
		sch.addGroup(4, 25, new int[] { 1 });
		sch.addGroup(5, 20, new int[] { 2, 3, 5 });
		sch.addGroup(6, 22, new int[] { 1, 4, 5 });
		sch.addGroup(7, 16, new int[] { 1, 3 });
		sch.addGroup(8, 18, new int[] { 2, 6 });
		sch.addGroup(9, 24, new int[] { 1, 6 });
		sch.addGroup(10, 25, new int[] { 3, 4 });
		
		 Individual in = new Individual(sch);
		 assertNotNull(in.getChromosome());
				
	}
    	}
