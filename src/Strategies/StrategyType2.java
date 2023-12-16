package Strategies;

import java.util.List;

import Chromosome.Chromosome;
import Chromosome.ChromosomeType;
import Crossovers.TwoPointCrossover;
import Mutations.BitFlipMutation;
import Mutations.RandomValueMutation;
import Population.Population;
import Selection.RouletteWheelSelection;

public class StrategyType2 implements Strategy {
    private RouletteWheelSelection rouletteWheelSelection = new RouletteWheelSelection();
    private TwoPointCrossover twoPointCrossover = new TwoPointCrossover();
    private BitFlipMutation bitFlipMutation = new BitFlipMutation();
    private RandomValueMutation randomValueMutation = new RandomValueMutation();

    @Override
    public List<Chromosome> selection(Population population) {
        return rouletteWheelSelection.selectParents(population);
    }

    @Override
    public Chromosome crossover(List<Chromosome> parents) {
        return twoPointCrossover.crossover(parents);
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
