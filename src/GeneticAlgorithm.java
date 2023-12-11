import java.util.List; // Add this import statement

public class GeneticAlgorithm {
    public static void main(String[] args) {
        int populationSize = 10; // Specify the desired population size
        String chromosomeType = "binary"; // Specify the desired chromosome type (binary or integer)

        // Create a population of binary chromosomes
        PopulationFactory populationFactory = PopulationFactory.getInstance();
        Population population = populationFactory.createPopulation(populationSize, chromosomeType);

        // Get the chromosomes from the population
        List<Chromosome> chromosomes = population.getChromosomes();

        // Print each binary chromosome
        for (int i = 0; i < chromosomes.size(); i++) {
            BinaryChromosome binaryChromosome = (BinaryChromosome) chromosomes.get(i);
            System.out.println("Chromosome " + (i + 1) + ": " + binaryChromosome.getGeneticCode());
        }
    }
}
