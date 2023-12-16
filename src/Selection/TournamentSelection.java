package Selection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Chromosome.Chromosome;
import Population.Population;

public class TournamentSelection {

    private static final int TOURNAMENT_SIZE = 3; // Default tournament size
    private Random random = new Random();

    public List<Chromosome> selectParents(Population population) {
        List<Chromosome> parents = new ArrayList<>();
        parents.add(tournament(population));
        parents.add(tournament(population));
        return parents;
    }

    private Chromosome tournament(Population population) {
      List<Chromosome> tournamentChromosomes = new ArrayList<>();
      // Add chromosomes to tournamentChromosomes as needed
      // For example, randomly select chromosomes from the input population

      Population tournament = new Population(tournamentChromosomes);
      
        for (int i = 0; i < TOURNAMENT_SIZE; i++) {
            Chromosome randomChromosome = population.getChromosomes().get(random.nextInt(population.getChromosomes().size()));
            tournament.addChromosome(randomChromosome);
        }
        return tournament.getBestChromosome();
    }
}
