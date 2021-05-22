package hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;

public class DepthLimitedNode<S extends State, O extends Operator<S>> extends AbstractNode<S, O, DepthLimitedNode<S, O>> {

    private final int depth;

    public DepthLimitedNode(S state, O operator, DepthLimitedNode<S, O> parent, int depth) {
        super(state, operator, parent);
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }

}
