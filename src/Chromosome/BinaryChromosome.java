package Chromosome;

import java.util.Random;

class BinaryChromosome extends Chromosome {
    private static final int GENETIC_CODE_LENGTH = 16; 

    public BinaryChromosome() {
      super();
      super.setGeneticCode(generateRandomBinaryCode(GENETIC_CODE_LENGTH));
      super.setType( ChromosomeType.BINARY );
    }


  
    // Generate a random binary code of the specified length
    private static String generateRandomBinaryCode(int length) {
        StringBuilder binaryCode = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            // Append random 0 or 1 to the binary code
            binaryCode.append(random.nextInt(2));
        }

        return binaryCode.toString();
    }

    

    // You can add specific methods for BinaryChromosome here
    // For example, methods to manipulate and evaluate binary data.
}