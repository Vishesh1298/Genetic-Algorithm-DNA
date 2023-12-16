package Population;

import java.util.List;
import Chromosome.Chromosome;

public class Population implements Operator {
    private List<Chromosome> chromosomes;

    public Population(List<Chromosome> chromosomes) {
        this.chromosomes = chromosomes;
    }

    public void addChromosome(Chromosome chromosome) {
        chromosomes.add(chromosome);
    }

    public void addChromosomes(List<Chromosome> newChromosomes) {
        chromosomes.addAll(newChromosomes);
    }

    public void removeChromosome(Chromosome chromosome) {
        chromosomes.remove(chromosome);
    }

    public void removeChromosomes(List<Chromosome> chromosomesToRemove) {
        chromosomes.removeAll(chromosomesToRemove);
    }

    public List<Chromosome> getChromosomes() {
        return chromosomes;
    }

    public void printAllChromosomes() {
        System.out.println("Chromosomes in the Population:");
        List<Chromosome> chromosomes = getChromosomes();
        for (int i = 0; i < chromosomes.size(); i++) {
            Chromosome chromosome = chromosomes.get(i);
            double fitness = chromosome.getFitness(); // You need to implement this method
            System.out.println("Chromosome " + i + ": Genetic Code: " + chromosome.getGeneticCode() + ", Fitness: " + fitness);
        }
    }

    // Operator

    @Override
    public void evaluateFitness() {
        // Implement fitness evaluation logic here
        // Calculate fitness values for each chromosome in the population.

        List<Chromosome> chromosomes = getChromosomes();

        for (Chromosome chromosome : chromosomes) {
            calculateFitness(chromosome);
        }
    }

    @Override
    public void calculateFitness(Chromosome chromosome) {
        // Implement your fitness calculation logic here.
        // Calculate the fitness value for the given chromosome.
        // Set the fitness value in the chromosome using a setter method or a property.

        String geneticCode = chromosome.getGeneticCode();

        // Example combined fitness calculation (replace with your actual logic):
        double fitness = 0.0;
        for (int i = 0; i < geneticCode.length(); i++) {
            if (geneticCode.charAt(i) == '1') {
                fitness += 1.0; // Increment fitness for '1' bits, adjust as needed.
            }
        }

        chromosome.setFitness(fitness);
    }

    @Override
    public Chromosome getBestChromosome() {

        if (chromosomes.isEmpty()) {
            return null; // Return null if the population is empty.
        }

        Chromosome bestChromosome = chromosomes.get(0);
        double bestFitness = bestChromosome.getFitness();

        for (Chromosome chromosome : chromosomes) {
            double fitness = chromosome.getFitness();
            if (fitness > bestFitness) {
                bestFitness = fitness;
                bestChromosome = chromosome;
            }
        }

        return bestChromosome;
    }
}
