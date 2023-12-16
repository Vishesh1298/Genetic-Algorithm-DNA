package Crossovers;
import java.util.List;
import java.util.Random;

import Chromosome.BinaryChromosomeFactory;
import Chromosome.Chromosome;
import Chromosome.ChromosomeFactory;
import Chromosome.ChromosomeType;
import Chromosome.IntegerChromosomeFactory;


public class SinglePointCrossover {

    private Random random = new Random();

    public Chromosome crossover(List<Chromosome> parents) {
        Chromosome parent1 = parents.get(0);
        ChromosomeFactory factory = getFactoryBasedOnType(parent1.getType());

        String geneticCode1 = parent1.getGeneticCode();
        String geneticCode2 = parents.get(1).getGeneticCode();
        
      
      String childGeneticCode = "";
      if (parent1.getType() == ChromosomeType.BINARY) {
          int crossoverPoint = random.nextInt(geneticCode1.length());
          childGeneticCode = geneticCode1.substring(0, crossoverPoint) + geneticCode2.substring(crossoverPoint);
      } else if (parent1.getType() == ChromosomeType.INTEGER) {
          for (int i = 0; i < geneticCode1.length(); i++) {
              int num1 = Character.getNumericValue(geneticCode1.charAt(i));
              int num2 = Character.getNumericValue(geneticCode2.charAt(i));
              int sum = (num1 + num2) % 10; // Ensuring single digit
              childGeneticCode += sum;
          }
      } else {
          throw new IllegalArgumentException("Unsupported Chromosome Type");
      }

        Chromosome child = factory.createChromosome();
        child.setGeneticCode(childGeneticCode);

      // Calculate the fitness of the new child chromosome
      child.calculateFitness();
      
        return child;
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
