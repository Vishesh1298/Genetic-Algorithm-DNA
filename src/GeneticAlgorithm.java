import java.util.List;

import Chromosome.Chromosome;
import Chromosome.ChromosomeType;
import Population.Population;
import Population.PopulationFactory;
import Strategies.Strategy;
import Strategies.StrategyType1;

public class GeneticAlgorithm {

    public static void main(String[] args) {
        // Assuming there are predefined default values for these parameters
        int defaultPopulationSize = 10;
        ChromosomeType defaultChromosomeType = ChromosomeType.BINARY; // or ChromosomeType.INTEGER
        int defaultGenerations = 5;
        double defaultMaxFitness = 16.0;
      Strategy strategy = new StrategyType1(); // set default strategy
      Chromosome bestChromosome = null;

        System.out.println("Genetic Algorithm Setup Details:");
        System.out.println("Population Size: " + defaultPopulationSize);
        System.out.println("Chromosome Type: " + defaultChromosomeType);
        System.out.println("Max Generations: " + defaultGenerations);
        System.out.println("Max Fitness: " + defaultMaxFitness);
        System.out.println();
      
        // Create Population
        PopulationFactory populationFactory = PopulationFactory.getInstance();
        Population population = populationFactory.initializePopulation(defaultPopulationSize, defaultChromosomeType);

      population.evaluateFitness(); // Evaluates fitness for all chromosomes in the population
      System.out.println("List of Initial Population as below:");
      // print all chromosome from population
      population.printAllChromosomes();
      System.out.println();
      
  

      String strategyType = strategy instanceof StrategyType1 ? 
        "StrategyType1 (TournamentSelection, SinglePointCrossover, " :
        "StrategyType2 (RouletteWheelSelection, TwoPointCrossover, ";
      if (defaultChromosomeType == ChromosomeType.BINARY) {
        System.out.println(strategyType + "BitFlipMutation)");
      }
      else if (defaultChromosomeType == ChromosomeType.INTEGER) {
        System.out.println(strategyType + "RandomValueMutation)");
      }
      else {
          throw new IllegalArgumentException("Unsupported Chromosome Type");
      }
      
      System.out.println();

        // Main loop
        for (int generation = 0; generation < defaultGenerations; generation++) {

          System.out.println("Generation " + generation);
          
            // Selection
            List<Chromosome> selectedParents = strategy.selection(population);
          for (Chromosome parent : selectedParents) {
              System.out.println("Parent - Genetic Code: " + parent.getGeneticCode() + ", Fitness: " + parent.getFitness());
          }

            // Crossover
            Chromosome child = strategy.crossover(selectedParents);
          System.out.println("Child: " + child.getGeneticCode() + ", Fitness: " + child.getFitness());;

            // Mutation
            strategy.mutation(child);
          System.out.println("Mutated Child: " + child.getGeneticCode() + ", Fitness: " + child.getFitness());

            // Add child to the population and evaluate fitness
            population.addChromosome(child);
            population.evaluateFitness(); // Assuming this method evaluates fitness for the entire population

            // Check for the best chromosome
            bestChromosome = population.getBestChromosome();
          System.out.println("Best Chromosome so far: " + bestChromosome.getGeneticCode() + " - Fitness: " + bestChromosome.getFitness());
          System.out.println();
          
          if (bestChromosome.getFitness() >= defaultMaxFitness) {
              System.out.println("Optimal Chromosome found in generation " + generation);
              break;
          }
        }
      System.out.println();
      System.out.println("Final Result: ");
      // Report the best Chromosome after the loop
      if (bestChromosome != null) {
          System.out.println("Best Chromosome after " + defaultGenerations + " generations: " + bestChromosome.getGeneticCode() + " - Fitness: " + bestChromosome.getFitness());
      } else {
          System.out.println("No optimal Chromosome found after " + defaultGenerations + " generations.");
      }
    }
}
