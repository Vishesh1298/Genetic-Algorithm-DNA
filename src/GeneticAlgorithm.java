import java.util.List;

import GA.Chromosome;
import GA.Operator;
import GA.Population;
import GA.PopulationFactory;
import Strategy.BitFlipMutation;
import Strategy.CrossoverStrategy;
import Strategy.MutationStrategy;
import Strategy.RouletteWheelSelection;
import Strategy.SelectionStrategy;
import Strategy.SinglePointCrossover;

public class GeneticAlgorithm implements Operator {
    private SelectionStrategy selectionStrategy; // Setting Different Selection Stratergies
    private CrossoverStrategy crossoverStrategy;
    private MutationStrategy mutationStrategy;

    public GeneticAlgorithm() {
        // Initialize with default strategies, you can replace these with your custom strategies
        this.selectionStrategy = new RouletteWheelSelection();
        this.crossoverStrategy = new SinglePointCrossover(null);
        this.mutationStrategy = new BitFlipMutation();
    }

    @Override
    public void applySelection(Population population) {
        selectionStrategy.applySelection(population);
    }

    @Override
    public void applyCrossover(Population population) {
        crossoverStrategy.applyCrossover(population);
    }

    @Override
    public void applyMutation(Population population) {
        mutationStrategy.applyMutation(population);
    }

    public void setSelectionStrategy(SelectionStrategy strategy) {
        this.selectionStrategy = strategy;
    }

    public void setCrossoverStrategy(CrossoverStrategy strategy) {
        this.crossoverStrategy = strategy;
    }

    public void setMutationStrategy(MutationStrategy strategy) {
        this.mutationStrategy = strategy;
    }

    public static void main(String[] args) {
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(); // Create an instance
        int populationSize = 10; // Specify the desired population size
        String chromosomeType = "binary";  // Specify the desired chromosome type (binary or integer) 

        // Create a population of binary chromosomes
        PopulationFactory populationFactory = PopulationFactory.getInstance();
        Population population = populationFactory.createPopulation(populationSize, chromosomeType);

        // Get the chromosomes from the population
        List<Chromosome> chromosomes = population.getChromosomes();

        // Print each chromosome
        for (int i = 0; i < chromosomes.size(); i++) {
            Chromosome chromosome = chromosomes.get(i);
            System.out.println("Chromosome " + (i + 1) + ": " + chromosome.getGeneticCode() + "Fitness :");
        }

        // Apply strategies
        System.out.println("Applying Selection");
        geneticAlgorithm.applySelection(population);

        System.out.println("Applying Crossover");
        geneticAlgorithm.applyCrossover(population);

        System.out.println("Applying Mutation");
        geneticAlgorithm.applyMutation(population);
    }

}