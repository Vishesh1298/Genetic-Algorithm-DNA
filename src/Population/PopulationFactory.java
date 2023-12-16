package Population;
import java.util.ArrayList;
import java.util.List;

import Chromosome.BinaryChromosomeFactory;
import Chromosome.Chromosome;
import Chromosome.ChromosomeType;
import Chromosome.IntegerChromosomeFactory;

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

  public Population initializePopulation(int size, ChromosomeType chromosomeType) {
      System.out.println("Applying initializePopulation...");

      List<Chromosome> chromosomes = new ArrayList<>();

      // Create the appropriate chromosome factory based on the chromosome type
      
      if (chromosomeType == ChromosomeType.BINARY) {
        BinaryChromosomeFactory binaryChromosomeFactory;
        binaryChromosomeFactory = BinaryChromosomeFactory.getInstance();

        // Create chromosomes using the factory
        for (int i = 0; i < size; i++) {
            Chromosome chromosome = binaryChromosomeFactory.createChromosome();
            chromosomes.add(chromosome);
        }
        
      } else if (chromosomeType == ChromosomeType.INTEGER) {
          IntegerChromosomeFactory integerChromosomeFactory;
          integerChromosomeFactory = IntegerChromosomeFactory.getInstance();

        // Create chromosomes using the factory
        for (int i = 0; i < size; i++) {
            Chromosome chromosome = integerChromosomeFactory.createChromosome();
            chromosomes.add(chromosome);
        }
      } else {
          throw new IllegalArgumentException("Invalid chromosome type. Supported types: binary, integer");
      }



      return new Population(chromosomes);
  }
}
