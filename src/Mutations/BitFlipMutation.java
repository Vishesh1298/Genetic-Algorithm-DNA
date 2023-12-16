package Mutations;
import java.util.Random;

import Chromosome.Chromosome;
import Chromosome.ChromosomeType;

public class BitFlipMutation {

    private Random random = new Random();

    public void mutate(Chromosome chromosome) {
        if (chromosome.getType() != ChromosomeType.BINARY) {
            throw new IllegalArgumentException("BitFlipMutation can only be applied to BinaryChromosomes");
        }

        String geneticCode = chromosome.getGeneticCode();
        int mutationPoint = random.nextInt(geneticCode.length());

        char mutatedBit = geneticCode.charAt(mutationPoint) == '0' ? '1' : '0';
        String mutatedGeneticCode = geneticCode.substring(0, mutationPoint) + mutatedBit + geneticCode.substring(mutationPoint + 1);

      chromosome.setGeneticCode(mutatedGeneticCode);
      chromosome.calculateFitness();
    }
}
