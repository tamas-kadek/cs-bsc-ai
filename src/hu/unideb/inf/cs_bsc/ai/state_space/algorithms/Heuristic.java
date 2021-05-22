package hu.unideb.inf.cs_bsc.ai.state_space.algorithms;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;

public interface Heuristic<S extends State> {

    double estimate(S state);

}
