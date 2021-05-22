package hu.unideb.inf.cs_bsc.ai.state_space.algorithms;

interface Frontier<N> {

    boolean isEmpty();

    void add(N node);

    N removeNext();

}
