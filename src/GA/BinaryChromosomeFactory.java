package GA;

public class BinaryChromosomeFactory implements ChromosomeFactory {
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
    public Chromosome createChromosome(String geneticCode) {
        return new BinaryChromosome(geneticCode);
    }
}
