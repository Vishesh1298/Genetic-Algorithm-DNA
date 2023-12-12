package Strategy;

import java.util.List;
import java.util.Random;

import GA.Chromosome;
import GA.ChromosomeFactory;
import GA.Population;

public class TwoPointCrossover implements CrossoverStrategy {
    private ChromosomeFactory chromosomeFactory; // New addition

    public TwoPointCrossover(ChromosomeFactory chromosomeFactory) {
        this.chromosomeFactory = chromosomeFactory;
    }

    @Override
    public void applyCrossover(Population population) {
        List<Chromosome> chromosomes = population.getChromosomes();
        Random random = new Random();

        for (int i = 0; i < chromosomes.size(); i += 2) {
            if (i + 1 < chromosomes.size()) {
                // Perform two-point crossover on pairs of chromosomes
                Chromosome parent1 = chromosomes.get(i);
                Chromosome parent2 = chromosomes.get(i + 1);

                int geneticCodeLength = parent1.getGeneticCode().length();
                int crossoverPoint1 = random.nextInt(geneticCodeLength);
                int crossoverPoint2 = random.nextInt(geneticCodeLength);

                // Ensure crossover points are distinct
                while (crossoverPoint1 == crossoverPoint2) {
                    crossoverPoint2 = random.nextInt(geneticCodeLength);
                }

                // Swap genetic code between crossover points
                if (crossoverPoint1 > crossoverPoint2) {
                    int temp = crossoverPoint1;
                    crossoverPoint1 = crossoverPoint2;
                    crossoverPoint2 = temp;
                }

                String newGeneticCode1 = parent1.getGeneticCode().substring(0, crossoverPoint1) +
                        parent2.getGeneticCode().substring(crossoverPoint1, crossoverPoint2) +
                        parent1.getGeneticCode().substring(crossoverPoint2);

                String newGeneticCode2 = parent2.getGeneticCode().substring(0, crossoverPoint1) +
                        parent1.getGeneticCode().substring(crossoverPoint1, crossoverPoint2) +
                        parent2.getGeneticCode().substring(crossoverPoint2);

                // Update the genetic code of the offspring using the factory
                Chromosome offspring1 = chromosomeFactory.createChromosome(newGeneticCode1);
                Chromosome offspring2 = chromosomeFactory.createChromosome(newGeneticCode2);

                // Replace the parents with the offspring in the population
                chromosomes.set(i, offspring1);
                chromosomes.set(i + 1, offspring2);
            }
        }
    }
}
