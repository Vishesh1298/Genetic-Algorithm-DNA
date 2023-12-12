public interface Operator {
    SelectionStrategy getDefaultSelectionStrategy();
    CrossoverStrategy getDefaultCrossoverStrategy();
    MutationStrategy getDefaultMutationStrategy();

    default void initializePopulation(Population population) {
        // Initialization logic
    }

    default void evaluateFitness(Population population) {
        // Fitness evaluation logic
    }

    default void calculateFitness(Chromosome chromosome) {
        // Fitness calculation logic
    }

    default void getBestChromosome(Population population) {
        // Get the best chromosome logic
    }

    // Setter methods for strategies
    default void setSelectionStrategy(SelectionStrategy strategy) {
        // Set a new selection strategy
        throw new UnsupportedOperationException("Cannot set default selection strategy in Operator interface.");
    }

    default void setCrossoverStrategy(CrossoverStrategy strategy) {
        // Set a new crossover strategy
        throw new UnsupportedOperationException("Cannot set default crossover strategy in Operator interface.");
    }

    default void setMutationStrategy(MutationStrategy strategy) {
        // Set a new mutation strategy
        throw new UnsupportedOperationException("Cannot set default mutation strategy in Operator interface.");
    }

    // Apply strategies to the population
    default void applySelection(Population population) {
        getDefaultSelectionStrategy().applySelection(population);
    }

    default void applyCrossover(Population population) {
        getDefaultCrossoverStrategy().applyCrossover(population);
    }

    default void applyMutation(Population population) {
        getDefaultMutationStrategy().applyMutation(population);
    }
}
