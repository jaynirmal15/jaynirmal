package geneticalgorithm.geneticalgorithm;

/**
*
* @author Jay
*/
public class Individual {

   private int[] chromosome;
   private double fitness = -1;

   public Individual(Schedule timetable) {
       int numClasses = timetable.getNumberOfClasses();
       // 1 gene for room, 1 for time, 1 for professor
       int chromosomeLength = numClasses * 3;
       // Create random individual
       int newlyGeneratedChromosome[] = new int[chromosomeLength];
       int chromosomeIndex = 0;
       // Loop through groups
       for (Group group : timetable.getGroupArray()) {
           // Loop through modules
           for (int courseId : group.getCourseIDs()) {
               // Add random time
               int timeslotId = timetable.getRandomTimeslot().getTimeSlotID();
               newlyGeneratedChromosome[chromosomeIndex] = timeslotId;
               chromosomeIndex++;
               // Add random room
               int roomId = timetable.getRandomRoom().getRoomID();
               newlyGeneratedChromosome[chromosomeIndex] = roomId;
               chromosomeIndex++;
               // Add random professor
               Course course = timetable.getCourse(courseId);
               newlyGeneratedChromosome[chromosomeIndex] = course.getRandomProfessorId();
               chromosomeIndex++;
               // Add random course           
           }
       }
       this.chromosome = newlyGeneratedChromosome;
   }

   public Individual(int chromosomeLength) {
       // Create random individual
       int[] individual;
       individual = new int[chromosomeLength];
       for (int gene = 0; gene < chromosomeLength; gene++) {
           individual[gene] = gene;
       }

       this.chromosome = individual;
   }
   public Individual(int[] chromosome) {
		// Create individual chromosome
		this.chromosome = chromosome;
	}
   public int[] getChromosome() {
		return this.chromosome;
	}
   public int getChromosomeLength() {
		return this.chromosome.length;
	}   
   public void setGene(int offset, int gene) {
		this.chromosome[offset] = gene;
	}
   public int getGene(int offset) {
		return this.chromosome[offset];
	}
   public void setFitness(double fitness) {
		this.fitness = fitness;
	}
   public double getFitness() {
		return this.fitness;
	}
   public String toString() {
		String output = "";
		for (int gene = 0; gene < this.chromosome.length; gene++) {
			output += this.chromosome[gene] + ",";
		}
		return output;
	}
   public boolean containsGene(int gene) {
		for (int i = 0; i < this.chromosome.length; i++) {
			if (this.chromosome[i] == gene) {
				return true;
			}
		}
		return false;
	}

}
