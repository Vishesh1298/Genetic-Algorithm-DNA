package Selection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Chromosome.Chromosome;
import Population.Population;

public class RouletteWheelSelection {

    private Random random = new Random();

    public List<Chromosome> selectParents(Population population) {
        List<Chromosome> parents = new ArrayList<>();
        parents.add(rouletteWheel(population));
        parents.add(rouletteWheel(population));
        return parents;
    }

    private Chromosome rouletteWheel(Population population) {
        double totalFitness = population.getChromosomes().stream().mapToDouble(Chromosome::getFitness).sum();
        double randomFitness = random.nextDouble() * totalFitness;
        double currentSum = 0;

        for (Chromosome chromosome : population.getChromosomes()) {
            currentSum += chromosome.getFitness();
            if (currentSum >= randomFitness) {
                return chromosome;
            }
        }
        return null; // Should not reach here if population is non-empty
    }
}
