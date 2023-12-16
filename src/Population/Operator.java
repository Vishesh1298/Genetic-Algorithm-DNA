package Population;

import Chromosome.Chromosome;

public interface Operator {
    void evaluateFitness();
    void calculateFitness( Chromosome chromosome );
    Chromosome getBestChromosome();
}
