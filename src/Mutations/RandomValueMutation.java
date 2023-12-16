package Mutations;
import java.util.Random;

import Chromosome.Chromosome;
import Chromosome.ChromosomeType;

public class RandomValueMutation {

    private Random random = new Random();

    public void mutate(Chromosome chromosome) {
        if (chromosome.getType() != ChromosomeType.INTEGER) {
            throw new IllegalArgumentException("RandomValueMutation can only be applied to IntegerChromosomes");
        }

        String geneticCode = chromosome.getGeneticCode();
        int mutationPoint = random.nextInt(geneticCode.length());

        char mutatedValue = Integer.toString(random.nextInt(10)).charAt(0);
        String mutatedGeneticCode = geneticCode.substring(0, mutationPoint) + mutatedValue + geneticCode.substring(mutationPoint + 1);

        chromosome.setGeneticCode(mutatedGeneticCode);
    }
}
