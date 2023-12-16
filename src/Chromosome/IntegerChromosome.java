package Chromosome;
import java.util.Random;

class IntegerChromosome extends Chromosome {
    private static final int GENETIC_CODE_LENGTH = 16; // Length of the integer genetic code
    private final ChromosomeType chromosomeType = ChromosomeType.INTEGER;

    public IntegerChromosome() {
        super();
      super.setGeneticCode( Integer.toString(generateRandomIntegerCode(GENETIC_CODE_LENGTH)));
      super.setType( ChromosomeType.INTEGER );
    }

    public ChromosomeType getType() {
        return chromosomeType;
    }

    // Generate a random integer code of the specified length
    private static int generateRandomIntegerCode(int length) {
      
        Random random = new Random();
        return random.nextInt((int) Math.pow(2, length));
    }
}