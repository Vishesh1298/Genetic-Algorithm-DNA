package Chromosome;
public class BinaryChromosomeFactory extends ChromosomeFactory {
    private static BinaryChromosomeFactory instance;

    private BinaryChromosomeFactory() {
    }

    public static BinaryChromosomeFactory getInstance() {
        if (instance == null) {
            instance = new BinaryChromosomeFactory();
        }
        return instance;
    }

    @Override
    public Chromosome createChromosome() {
        return new BinaryChromosome();
    }
}
