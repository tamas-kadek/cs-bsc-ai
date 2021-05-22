package hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Successor;

public class SimpleNodeBuilder<S extends State, O extends Operator<S>> implements NodeBuilder<S, O, SimpleNode<S, O>> {

    @Override
    public SimpleNode<S, O> buildFrom(S start) {
        return new SimpleNode<>(start, null, null);
    }

    @Override
    public SimpleNode<S, O> buildFrom(SimpleNode<S, O> node, Successor<S, O> successor) {
        return new SimpleNode<>(successor.getState(), successor.getCreator(), node);
    }

}