package Strategies;

import java.util.List;

import Chromosome.Chromosome;
import Chromosome.ChromosomeType;
import Crossovers.SinglePointCrossover;
import Mutations.BitFlipMutation;
import Mutations.RandomValueMutation;
import Population.Population;
import Selection.TournamentSelection;

public class StrategyType1 implements Strategy {
    private TournamentSelection tournamentSelection = new TournamentSelection();
    private SinglePointCrossover singlePointCrossover = new SinglePointCrossover();
    private BitFlipMutation bitFlipMutation = new BitFlipMutation();
    private RandomValueMutation randomValueMutation = new RandomValueMutation();

    @Override
    public List<Chromosome> selection(Population population) {
        return tournamentSelection.selectParents(population);
    }

    @Override
    public Chromosome crossover(List<Chromosome> parents) {
        return singlePointCrossover.crossover(parents);
    }

    @Override
    public void mutation(Chromosome child) {
        if (child.getType() == ChromosomeType.BINARY) {
            bitFlipMutation.mutate(child);
        } else if (child.getType() == ChromosomeType.INTEGER) {
            randomValueMutation.mutate(child);
        }
    }
}
