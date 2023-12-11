abstract class Chromosome {
    private String geneticCode; // Genetic code represented as a string
    private double fitness; // Fitness value of the chromosome

    public Chromosome(String geneticCode) {
        this.geneticCode = geneticCode;
        this.fitness = 0.0; // Initialize fitness to 0; you can set it as needed.
    }

    // Getter and setter methods for geneticCode
    public String getGeneticCode() {
        return geneticCode;
    }

    public void setGeneticCode(String geneticCode) {
        this.geneticCode = geneticCode;
    }

    // Getter and setter methods for fitness
    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    // You can add common methods for manipulating genetic code and fitness here
    // For example, methods to compute fitness, mutate, or crossover genetic code.
}
