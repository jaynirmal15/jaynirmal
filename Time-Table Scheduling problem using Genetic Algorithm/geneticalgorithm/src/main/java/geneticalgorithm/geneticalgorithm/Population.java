package geneticalgorithm.geneticalgorithm;


import java.util.Arrays;
import java.util.Comparator;

import java.util.Random;

/**
 *
 * @author Jay
 */
public class Population {
    private Individual population[];
	private double populationFitness = -1;
        public Population(int populationSize) {
		// Initial population
		this.population = new Individual[populationSize];
	}
        public Population(int populationSize, Schedule timetable) {
		// Initial population
		this.population = new Individual[populationSize];

		// Loop over population populationSize
		for (int i = 0; i < populationSize; i++) {
			// Create individual
			Individual individual = new Individual(timetable);
			// Add individual to population
			this.population[i] = individual;
		}
	}
        public Population(int populationSize, int chromosomeLength) {
		this.population = new Individual[populationSize];
		for (int i = 0; i < populationSize; i++) {
			Individual individual = new Individual(chromosomeLength);
			this.population[i] = individual;
		}
	}
        public Individual[] getIndividuals() {
		return this.population;
	}
        public Individual getFittest(int offset) {
            //tried to implement priority queue
		// Order population by fitness
                
//               PriorityQueue<Individual> pq = new
//             PriorityQueue<Individual>(this.population.length, new Comparator<Individual>() {
//                   @Override
//                   public int compare(Individual o1, Individual o2) {
//				if (o1.getFitness() > o2.getFitness()) {
//					return -1;
//				} else if (o1.getFitness() < o2.getFitness()) {
//					return 1;
//				}
//				return 0;
//			}
//                   
//               });
//               for(int i = 0;i<this.population.length;i++)
//               {
//               pq.add(this.population[i]);
//               }
               
		Arrays.sort(this.population, new Comparator<Individual>() {
			
			public int compare(Individual o1, Individual o2) {
				if (o1.getFitness() > o2.getFitness()) {
					return -1;
				} else if (o1.getFitness() < o2.getFitness()) {
					return 1;
				}
				return 0;
			}
			
		});

		// Return the fittest individual
           //     return pq.poll();		
            return this.population[offset];
	}
        public void setPopulationFitness(double fitness) {
		this.populationFitness = fitness;
	}
        public double getPopulationFitness() {
		return this.populationFitness;
	}
        public int populationSize() {
		return this.population.length;
	}
        public Individual setIndividual(int offset, Individual individual) {
		return population[offset] = individual;
	}
        public Individual getIndividual(int offset) {
		return population[offset];
	}
        public void shuffle() {
		Random rnd = new Random();
		for (int i = population.length - 1; i > 0; i--) {
			int j = rnd.nextInt(i + 1);
			Individual ind = population[j];
			population[j] = population[i];
			population[i] = ind;
		}
	}
}
