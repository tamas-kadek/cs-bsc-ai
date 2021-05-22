package hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;

public class SimpleNode<S extends State, O extends Operator<S>> extends AbstractNode<S, O, SimpleNode<S, O>> {

    public SimpleNode(S state, O operator, SimpleNode<S, O> parent) {
        super(state, operator, parent);
    }

}
