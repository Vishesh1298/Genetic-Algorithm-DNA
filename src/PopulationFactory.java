import java.util.ArrayList;
import java.util.List;

public class PopulationFactory {
    private static volatile PopulationFactory instance;

    private PopulationFactory() {
        // Private constructor to prevent instantiation from other classes.
    }

    public static PopulationFactory getInstance() {
        if (instance == null) {
            synchronized (PopulationFactory.class) {
                if (instance == null) {
                    instance = new PopulationFactory();
                }
            }
        }
        return instance;
    }

    public Population createPopulation(int size, String chromosomeType) {
        List<Chromosome> chromosomes = new ArrayList<>();

        if ("binary".equalsIgnoreCase(chromosomeType)) {
            for (int i = 0; i < size; i++) {
                BinaryChromosome binaryChromosome = new BinaryChromosome();
                chromosomes.add(binaryChromosome);
            }
        } else if ("integer".equalsIgnoreCase(chromosomeType)) {
            for (int i = 0; i < size; i++) {
                IntegerChromosome integerChromosome = new IntegerChromosome();
                chromosomes.add(integerChromosome);
            }
        } else {
            throw new IllegalArgumentException("Invalid chromosome type. Supported types: binary, integer");
        }

        return new Population(chromosomes);
    }
}
