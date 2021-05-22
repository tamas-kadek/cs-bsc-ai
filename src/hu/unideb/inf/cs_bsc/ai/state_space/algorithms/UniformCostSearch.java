package hu.unideb.inf.cs_bsc.ai.state_space.algorithms;

import hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database.FrontierBuilder;
import hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database.PriorityNode;
import hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database.PriorityQueue;
import hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database.UniformNodeBuilder;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Problem;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;

import java.util.Optional;

public class UniformCostSearch<S extends State, O extends Operator<S>> implements Algorithm<S, O> {

    private final SearchStrategy strategy;

    private final EdgeCost<S, O> edgeCost;

    public UniformCostSearch(SearchStrategy strategy, EdgeCost<S, O> edgeCost) {
        this.strategy = strategy;
        this.edgeCost = edgeCost;
    }

    @Override
    public Optional<Solution<S, O>> findSolution(Problem<S, O> problem) {
        UniformNodeBuilder<S, O> nodeBuilder = new UniformNodeBuilder<>(edgeCost);
        FrontierBuilder<PriorityNode<S, O>> frontierBuilder = () -> new PriorityQueue<>(PriorityNode<S, O>::getEvaluation);
        return strategy.findSolution(problem, frontierBuilder, nodeBuilder);
    }

}
