package GA;
import Strategy.CrossoverStrategy;
import Strategy.MutationStrategy;
import Strategy.SelectionStrategy;

public interface Operator {
    // SelectionStrategy getDefaultSelectionStrategy();
    // CrossoverStrategy getDefaultCrossoverStrategy();
    // MutationStrategy getDefaultMutationStrategy();

    // void initializePopulation(Population population);

    // void evaluateFitness(Population population);

    // void calculateFitness(Chromosome chromosome);

    // void getBestChromosome(Population population);

    void setSelectionStrategy(SelectionStrategy strategy);

    void setCrossoverStrategy(CrossoverStrategy strategy);

    void setMutationStrategy(MutationStrategy strategy);

    void applySelection(Population population);

    void applyCrossover(Population population);

    void applyMutation(Population population);
}