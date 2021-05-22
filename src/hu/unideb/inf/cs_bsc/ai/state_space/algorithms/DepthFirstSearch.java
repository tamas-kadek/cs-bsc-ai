package hu.unideb.inf.cs_bsc.ai.state_space.algorithms;

import hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database.SimpleNodeBuilder;
import hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database.Stack;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Problem;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;

import java.util.Optional;

public class DepthFirstSearch<S extends State, O extends Operator<S>> implements Algorithm<S, O> {

    private final SearchStrategy strategy;

    public DepthFirstSearch(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Optional<Solution<S, O>> findSolution(Problem<S, O> problem) {
        return strategy.findSolution(problem, Stack::new, new SimpleNodeBuilder<>());
    }

}
