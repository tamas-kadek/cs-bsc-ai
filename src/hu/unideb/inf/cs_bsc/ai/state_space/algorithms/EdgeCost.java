package hu.unideb.inf.cs_bsc.ai.state_space.algorithms;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Successor;

@FunctionalInterface
public interface EdgeCost<S extends State, O extends Operator<S>> {

    double cost(S state, O operator);

    default double cost(Successor<S, O> successor) {
        return cost(successor.getState(), successor.getCreator());
    }

}
