package hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database;

public interface Frontier<N> {

    boolean isEmpty();

    void add(N node);

    N removeNext();

}
