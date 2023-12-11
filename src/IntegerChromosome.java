import java.util.Random;

class IntegerChromosome extends Chromosome {
    private static final int GENETIC_CODE_LENGTH = 8; // Length of the integer genetic code

    public IntegerChromosome() {
        super(Integer.toString(generateRandomIntegerCode(GENETIC_CODE_LENGTH)));
    }

    // Generate a random integer code of the specified length
    private static int generateRandomIntegerCode(int length) {
        Random random = new Random();
        return random.nextInt((int) Math.pow(2, length));
    }

    // You can add specific methods for IntegerChromosome here
    // For example, methods to manipulate and evaluate integer data.
}