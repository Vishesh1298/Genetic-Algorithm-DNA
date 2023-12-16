package Chromosome;
public abstract class Chromosome {
    private String geneticCode;
    private double fitness;
    private ChromosomeType type;

    public Chromosome() {
        this.geneticCode = "";
        this.fitness = 0.0;
        this.type = null;
    }

    public String getGeneticCode() {
        return geneticCode;
    }

    public void setGeneticCode(String geneticCode) {
        this.geneticCode = geneticCode;
    }
  
  public void setType(ChromosomeType type) {
     this.type = type;
  }
  
    public ChromosomeType getType() {
      return type;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

  public void calculateFitness() {
      if (this.type == ChromosomeType.BINARY) {
          // Fitness calculation for Binary chromosome
          // Example: Counting the number of '1's
          this.fitness = geneticCode.chars().filter(ch -> ch == '1').count();
      } else if (this.type == ChromosomeType.INTEGER) {
          // Fitness calculation for Integer chromosome
          // Example: Proximity to a target number
          int target = 1000; // Define a target for illustration
          int value = Integer.parseInt(geneticCode);
          this.fitness = 1.0 / (1.0 + Math.abs(target - value)); // Closer to target means higher fitness
      } else {
          throw new IllegalArgumentException("Unsupported Chromosome Type");
      }
  }
}
