public abstract class Chromosome {
    private String geneticCode;
    private double fitness;
    private boolean selectedAsParent;

    public Chromosome(String geneticCode) {
        this.geneticCode = geneticCode;
        this.fitness = 0.0;
        this.selectedAsParent = false; // Initialize to false
    }

    public String getGeneticCode() {
        return geneticCode;
    }

    public void setGeneticCode(String geneticCode) {
        this.geneticCode = geneticCode;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public boolean isSelectedAsParent() {
        return selectedAsParent;
    }

    public void setSelectedAsParent(boolean selectedAsParent) {
        this.selectedAsParent = selectedAsParent;
    }

    // You can add common methods for manipulating genetic code and fitness here
    // For example, methods to compute fitness, mutate, or crossover genetic code.
}
