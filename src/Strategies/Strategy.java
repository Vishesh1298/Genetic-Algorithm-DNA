package Strategies;

import java.util.List;

import Chromosome.Chromosome;
import Population.Population;

public interface Strategy {
    List<Chromosome> selection(Population population);
    Chromosome crossover(List<Chromosome> parents);
    void mutation(Chromosome child);
}
