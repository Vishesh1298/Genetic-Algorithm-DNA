public interface Operator {
    default void initializePopulation(Population population) {
      
    }
  
    default void evaluateFitness(Population population) {
      
    }
  
    default void calculateFitness(Chromosome chromosome) {
      
    }
  
    default void getBestChromosome(Population population) {
      
    }
}
