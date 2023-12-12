package GA;

public class IntegerChromosomeFactory implements ChromosomeFactory {
    private static IntegerChromosomeFactory instance;

    private IntegerChromosomeFactory() {
    }

    public static IntegerChromosomeFactory getInstance() {
        if (instance == null) {
            instance = new IntegerChromosomeFactory();
        }
        return instance;
    }

    @Override
    public Chromosome createChromosome(String geneticCode) {
        return new IntegerChromosome(geneticCode);
    }
}
