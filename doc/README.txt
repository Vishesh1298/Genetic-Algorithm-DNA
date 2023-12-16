# CS613 Group CA - Genetic Algorithm
- TeamMember1: Chi Ieong Ng 22252446: 25% effort
- TeamMember2: Vishesh 25% effort
- TeamMember3 Rohan 25% effort
- TeamMember4 Charan 25% effort

############################################################################################

## File Structure:
root/\
└── src/\
| ├── BinaryChromosome.java\
| ├── BinaryChromosomeFactory.java\
| ├── BitFlipMutation.java\
| ├── Chromosome.java\
| ├── ChromosomeFactory.java\
| ├── ChromosomeFactory.java\
| ├── ChromosomeType.java\
| ├── GeneticAlgorithm.java\
| ├── IntegerChromosome.java\
| ├── IntegerChromosomeFactory.java\
| ├── Operator.java\
| ├── Population.java\
| ├── PopulationFactory.java\
| ├── RandomValueMutation.java\
| ├── RouletteWheelSelection.java\
| ├── SinglePointCrossover.java\
| ├── Strategy.java\
| ├── StrategyType1.java\
| ├── StrategyType2.java\
| ├── TournamentSelection.java\
| └── TwoPointCrossover.java\
└── bin/\
└── doc/\
└── README.txt\
└── README.md\

############################################################################################

## File Description
- `BinaryChromosomeFactory.java`: A factory class for creating instances of BinaryChromosome. It follows the Singleton pattern, ensuring only one instance of the factory exists.

- `Chromosome.java`: An abstract class representing a chromosome. It holds a genetic code, fitness value, and chromosome type.

- `ChromosomeFactory.java`: An abstract factory class for creating chromosomes. This is likely used as a base for other specific chromosome factory classes.

- `ChromosomeType.java`: An enumeration defining types of chromosomes, specifically BINARY and INTEGER.

- `IntegerChromosome.java`: Extends Chromosome, representing a chromosome with an integer genetic code. Includes functionality to generate random integer codes.

- `IntegerChromosomeFactory.java`: A factory class for creating instances of IntegerChromosome, also following the Singleton pattern.

- `Operator.java`: An interface defining operations for evaluating fitness and selecting the best chromosome. This is probably used in the context of a genetic algorithm.

- `Population.java`: Represents a population of chromosomes. Implements the Operator interface, suggesting it can evaluate fitness and manage chromosomes.

- `PopulationFactory.java`: A factory class for creating instances of Population, also following the Singleton pattern.

- `BinaryChromosome.java`: Extends Chromosome, representing a chromosome with a binary genetic code. Includes functionality to generate random binary codes.

- `TournamentSelection.java`: Implements a tournament-style selection process for choosing parent chromosomes in a genetic algorithm.

- `TwoPointCrossover.java`: Defines a two-point crossover technique for combining genetic information from parent chromosomes.

- `BitFlipMutation.java`: Provides functionality for mutating binary chromosomes by flipping a bit at a random position.

- `GeneticAlgorithm.java`: The main class for setting up and running the genetic algorithm process.

- `RandomValueMutation.java`: Implements mutation for non-binary chromosomes by changing a value randomly.

- `RouletteWheelSelection.java`: A selection method using roulette wheel strategy to choose parent chromosomes based on fitness.

- `SinglePointCrossover.java`: A crossover method combining parent chromosomes' genetic information at a single point.

- `Strategy.java`: An interface defining methods for selection, crossover, and mutation in a genetic algorithm.

- `StrategyType1.java`: Implements Strategy with specific methods like tournament selection, single-point crossover, and bit flip mutation.

- `StrategyType2.java`: Another implementation of Strategy, using roulette wheel selection, two-point crossover, and combined mutations. 

############################################################################################

## Compile and Run: 
To compile the code:
- javac -d bin src/*.java
To run the code:
- java -cp bin GeneticAlgorithm

############################################################################################

## Output Explanation
ScreenShot: output.jpg (attached)

Explanation:
- **Initial Setup:** The output details the genetic algorithm's initial configuration, including population size (10), chromosome type (BINARY), maximum generations (5), and a target for maximum fitness (16.0). The goal is to evolve the population until the best chromosome reaches the maximum fitness or the maximum number of generations is reached.
- **Population Initialization:** Displays the initial population, listing the genetic code and fitness of each chromosome. This is crucial for observing how the population evolves over time.
- **StrategyType1 Implementation:** The algorithm employs StrategyType1, which utilizes TournamentSelection for parent selection, SinglePointCrossover for breeding new chromosomes, and BitFlipMutation for introducing genetic variability. This combination of strategies is designed to efficiently explore and exploit the genetic space.
- **Generational Progress**: The algorithm iteratively goes through generations, showcasing how parent chromosomes are selected, crossed over, and mutated. The fitness values indicate the evolutionary progress of the population.
- **Monitoring for Maximum Fitness**: One key aspect of the algorithm's progression is monitoring whether any chromosome achieves or surpasses the maximum fitness value, which could trigger the conclusion of the algorithm before reaching the set number of generations.
- **Concluding Results:** The final output presents the best chromosome obtained after maximum generations or upon achieving the maximum fitness. This indicates the success of the genetic algorithm in optimizing towards the desired goal.