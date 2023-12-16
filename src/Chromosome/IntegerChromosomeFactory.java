package Chromosome;


public class IntegerChromosomeFactory extends ChromosomeFactory {
    private static IntegerChromosomeFactory instance = new IntegerChromosomeFactory();

    private IntegerChromosomeFactory() {
    }

    public static IntegerChromosomeFactory getInstance() {
        return instance;
    }

    @Override
    public Chromosome createChromosome() {
        return new IntegerChromosome();
    }
}