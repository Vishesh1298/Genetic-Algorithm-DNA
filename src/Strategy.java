public interface Strategy {
    void selection(Population population);
    void crossCross(Population population);
    void mutation(Population population);
}