package hu.unideb.inf.cs_bsc.ai.state_space.algorithms;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Problem;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;

import java.util.Optional;

public class IterativeDeepening<S extends State, O extends Operator<S>> implements Algorithm<S, O> {

    public Optional<Solution<S, O>> findSolution(Problem<S, O> p) {
        for (int i = 1; true; i++) {
            DepthLimited<S, O> depthLimited = new DepthLimited<>(i);
            Optional<Solution<S, O>> solution = depthLimited.findSolution(p);
            if (solution.isPresent())
                return solution;
        }
    }

}
