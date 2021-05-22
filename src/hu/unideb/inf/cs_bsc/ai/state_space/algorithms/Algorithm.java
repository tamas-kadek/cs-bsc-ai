package hu.unideb.inf.cs_bsc.ai.state_space.algorithms;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Problem;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;

import java.util.Optional;

public interface Algorithm<S extends State, O extends Operator<S>> {

    Optional<Solution<S, O>> findSolution(Problem<S, O> problem);

}
