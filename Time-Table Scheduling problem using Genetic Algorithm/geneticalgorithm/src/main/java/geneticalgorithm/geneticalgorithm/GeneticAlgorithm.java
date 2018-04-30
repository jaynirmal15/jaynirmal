package geneticalgorithm.geneticalgorithm;

import java.util.Random;


public class GeneticAlgorithm {
	  private int populationSize;
	    private double mutationRate;
	    private double crossoverRate;
	    private int elitismCount;
	    protected int tournamentSize;

	    public GeneticAlgorithm(int populationSize, double mutationRate, double crossoverRate, int elitismCount,
	            int tournamentSize) {

	        this.populationSize = populationSize;
	        this.mutationRate = mutationRate;
	        this.crossoverRate = crossoverRate;
	        this.elitismCount = elitismCount;
	        this.tournamentSize = tournamentSize;
	    }
	    //Creating initial population

	    public Population initPopulation(Schedule timetable) {
	        Population population = new Population(this.populationSize, timetable);
	        return population;
	    }

	    //function to calculate fitness based on the number of clashes
	    public double calcFitness(Individual individual, Schedule timetable) {
	        Schedule newTimeTable = new Schedule(timetable);
	        newTimeTable.createNewClasses(individual);
	        int numberOfClashes = newTimeTable.calculateClashes();
	        double fitness = 1 / (double) (numberOfClashes + 1);
	        individual.setFitness(fitness);
	        return fitness;
	    }

	    //function select the first parent for crossover
	    public Individual selectParent1(Population population) {
	        Population tournament = new Population(this.tournamentSize);
	        population.shuffle();
	        for (int i = 0; i < this.tournamentSize; i++) {
	            Individual tournamentIndividual = population.getIndividual(i);
	            tournament.setIndividual(i, tournamentIndividual);
	        }

	        return tournament.getFittest(0);
	    }

	    //function to select the second parent for crossover
	    public Individual selectParent2(Population population) {
	        Population tournament = new Population(this.tournamentSize);
	        population.shuffle();
	        for (int i = 0; i < this.tournamentSize; i++) {
	            Individual tournamentIndividual = population.getIndividual(i);
	            tournament.setIndividual(i, tournamentIndividual);
	        }
	        return tournament.getFittest(1);
	    }

	    //perform crossover
	    public Population crossoverPopulation(Population population) {
	        Population newPopulation = new Population(population.populationSize());
	        Random r = new Random();
	        //loop over the population      
	        for (int i = 0; i < population.populationSize(); i++) {

	            Individual parent1 = selectParent1(population);
	            Individual parent2 = selectParent2(population);
	            if (i >= elitismCount && this.crossoverRate > r.nextInt()) {
	                //     initiliaze the offspring
	                Individual offspring = new Individual(parent1.getChromosomeLength());
	                int crossOverPoint = r.nextInt(parent1.getChromosomeLength());
	                for (int j = 0; j < parent1.getChromosomeLength(); j++) {
	                    if (j < crossOverPoint) {
	                        offspring.setGene(j, parent1.getGene(j));

	                    } else {
	                        offspring.setGene(j, parent2.getGene(j));
	                    }
	                }
	                newPopulation.setIndividual(i, offspring);
	            } else {
	                newPopulation.setIndividual(i, parent1);
	            }
	        }
	        return newPopulation;
	    }

	    //perform mutation
	    public Population mutatePopulation(Population population, Schedule schedule) {
	        //initializing the new population
	        Population newPopulation = new Population(this.populationSize);
	        for (int i = 0; i < population.populationSize(); i++) {
	            Individual individual = population.getFittest(i);
	            //creating random individual for mutation from the schedule
	            Individual randomIndividual = new Individual(schedule);
	            for (int j = 0; j < individual.getChromosomeLength(); j++) {

	                if (i > this.elitismCount) {
	                    if (this.mutationRate > Math.random()) {
	                        //swap the genes
	                        individual.setGene(j, randomIndividual.getGene(j));
	                    }
	                }
	            }
	            newPopulation.setIndividual(i, individual);
	        }

	        return newPopulation;
	    }

	//check if the generation number exceeds the maximum value if we do not get the fittest solution till this point
	    public boolean GenerationReachedToMaximumPoint(int generationNumber, int maxCount) {
	        if (generationNumber > maxCount) {
	            return true;
	        }
	        return false;
	    }
	//stop when we get the fittest chromosome 

	    public boolean isTerminationConditionMet(Population population) {
	        if (population.getFittest(0).getFitness() == 1.0) {
	            System.out.println("Fittest Chromesome(sequence of timeslotID , roomID and professorID) :\n " + population.getFittest(0));
	            return true;
	        }
	        return false;
	    }

	    public void evalPopulation(Population population, Schedule timetable) {
	        double populationFitness = 0;
	        for (Individual individual : population.getIndividuals()) {
	            populationFitness += this.calcFitness(individual, timetable);
	        }
	        population.setPopulationFitness(populationFitness);
	    }
}
