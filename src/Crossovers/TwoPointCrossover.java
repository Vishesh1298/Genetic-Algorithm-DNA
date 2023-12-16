package Crossovers;
import java.util.List;
import java.util.Random;

import Chromosome.BinaryChromosomeFactory;
import Chromosome.Chromosome;
import Chromosome.ChromosomeFactory;
import Chromosome.ChromosomeType;
import Chromosome.IntegerChromosomeFactory;

public class TwoPointCrossover {

    private Random random = new Random();

    public Chromosome crossover(List<Chromosome> parents) {
        Chromosome parent1 = parents.get(0);
        ChromosomeFactory factory = getFactoryBasedOnType(parent1.getType());

        String geneticCode1 = parent1.getGeneticCode();
        String geneticCode2 = parents.get(1).getGeneticCode();

        String childGeneticCode = "";
        if (parent1.getType() == ChromosomeType.BINARY) {
            childGeneticCode = binaryTwoPointCrossover(geneticCode1, geneticCode2);
        } else if (parent1.getType() == ChromosomeType.INTEGER) {
            childGeneticCode = integerTwoPointCrossover(geneticCode1, geneticCode2);
        } else {
            throw new IllegalArgumentException("Unsupported Chromosome Type");
        }

        Chromosome child = factory.createChromosome();
        child.setGeneticCode(childGeneticCode);
        child.calculateFitness();

        return child;
    }

    private String binaryTwoPointCrossover(String code1, String code2) {
        int point1 = random.nextInt(code1.length());
        int point2 = random.nextInt(code1.length());

        int start = Math.min(point1, point2);
        int end = Math.max(point1, point2);

        return code1.substring(0, start) + code2.substring(start, end) + code1.substring(end);
    }

    private String integerTwoPointCrossover(String code1, String code2) {
        int point1 = random.nextInt(code1.length());
        int point2 = random.nextInt(code1.length());

        int start = Math.min(point1, point2);
        int end = Math.max(point1, point2);

        StringBuilder childCode = new StringBuilder(code1);
        for (int i = start; i < end; i++) {
            childCode.setCharAt(i, code2.charAt(i));
        }

        return childCode.toString();
    }

    private ChromosomeFactory getFactoryBasedOnType(ChromosomeType type) {
        switch (type) {
            case BINARY:
                return BinaryChromosomeFactory.getInstance();
            case INTEGER:
                return IntegerChromosomeFactory.getInstance();
            default:
                throw new IllegalArgumentException("Unknown Chromosome Type");
        }
    }
}
