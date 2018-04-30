# INFO6205_323
PROGRAM STRUCTURES ALGORITHM
Team Members : 
Jay Suresh Nirmal
Karan  Kathayat

Problem :-
This project is one of the live problem which I faced during my course Registration.
The problem for scheduling Time-table for all the courses of a college is sometimes the course timings might clash 
due to which a student cannot enroll in that subject.
timetable scheduling problem presents a set of tasks (classes) and a set of resources (rooms, groups, instructors).
Every task requests some resources for its realization and has the exact length.
The set of timeslots when a class can be scheduled is also determined.
The goal is to assign those tasks to their resources while satisfying all of the hard constraints - no resource should be allocated by multiple tasks at the same time
The main goal of the genetic algorithm presented here is to achieve a feasible timetable.
Implementation: -
1. The program uses selection that is it selected the best individuals from the current population and eliminating bad individuals and making room for new children.
   The selecting parents(individuals) is based on their fitness value.
   It might be possible the some of the best individuals might be eliminated during the process which would decrease the efficieny of the algorithm and it will again have search a good individual for a number of generations.
   So to protect the best individuals I have kept an elitism count i.e never do crossover or mutation the top(elitism number) individuals from the population.
Selection code : =
   public Individual selectParent1(Population population) {
        Population tournament = new Population(this.tournamentSize);
        population.shuffle();
        for (int i = 0; i < this.tournamentSize; i++) {
            Individual tournamentIndividual = population.getIndividual(i);
            tournament.setIndividual(i, tournamentIndividual);
        }
       
        return tournament.getFittest(0);
    }
2. Next is calulating the fitness function :=
   two functions contribute to the fitness function
   1. counting the number of clashes.
	(1.If roomSize is greater than the size of total number of students.)
	(2. If the same room and same time slot is assigned to conduct two different classes)
	(3. If the same professor is assigned to two different class at the same timeslot)
   2. calculating the fitness function based on the number of clashes.
      logic :-double fitness = 1 / (double) (numberOfClashes + 1);
3. Genetic code : - the chromosome is composed of set of all the classes with 1 gene of roomID, 1 gene of timeSlotID and 1 gene of professorID asssociated with a course.
		So the chromosome length will be equal to 3*totalNumberOfClasses.

3. Crossover function : -
     Using selection function we select two parents for crossover.A random crossove point is selected and in the offspring we put parent1 genes till the crossover point and then the rest with parent two genes.
     for (int i = 0; i < population.populationSize(); i++) {

            Individual parent1 = selectParent1(population);
            Individual parent2 = selectParent2(population);
            if (i >= elitismCount) {
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
4. mutation : -
      A random individual is selected and if the index is less than the elitism count mutation is performed the is randomly put genes in the fittest soution for each iteration.
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
