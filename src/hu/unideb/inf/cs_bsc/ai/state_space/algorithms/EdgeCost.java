package hu.unideb.inf.cs_bsc.ai.state_space.algorithms;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;

@FunctionalInterface
public interface EdgeCost<S extends State, O extends Operator<S>> {

    double cost(S state, O operator);

}
