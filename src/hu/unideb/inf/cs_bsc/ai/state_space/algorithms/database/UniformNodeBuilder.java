package hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database;

import hu.unideb.inf.cs_bsc.ai.state_space.algorithms.EdgeCost;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Successor;

public class UniformNodeBuilder<S extends State, O extends Operator<S>> implements NodeBuilder<S, O, PriorityNode<S, O>> {

    private final EdgeCost<S, O> edgeCost;

    public UniformNodeBuilder(EdgeCost<S, O> edgeCost) {
        this.edgeCost = edgeCost;
    }

    @Override
    public PriorityNode<S, O> buildFrom(S start) {
        return new PriorityNode<>(start, null, null, 0);
    }

    @Override
    public PriorityNode<S, O> buildFrom(PriorityNode<S, O> node, Successor<S, O> successor) {
        double pathCost = node.getEvaluation() + edgeCost.cost(successor);
        return new PriorityNode<>(successor.getState(), successor.getCreator(), node, pathCost);
    }

}
