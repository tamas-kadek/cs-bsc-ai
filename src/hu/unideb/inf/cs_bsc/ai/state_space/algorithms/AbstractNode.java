package hu.unideb.inf.cs_bsc.ai.state_space.algorithms;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Successor;

import java.util.LinkedList;

abstract class AbstractNode<S extends State, O extends Operator<S>, N extends AbstractNode<S, O, N>> {

    private final S state;

    private final O creator;

    private final N parent;

    protected AbstractNode(S state, O creator, N parent) {
        this.state = state;
        this.creator = creator;
        this.parent = parent;
    }

    public S getState() {
        return state;
    }

    public O getCreator() {
        return creator;
    }

    public N getParent() {
        return parent;
    }

    public abstract N newChild(Successor<S, O> successor);

    public Solution<S, O> toSolution() {
        LinkedList<O> path = new LinkedList<>();
        for (AbstractNode<S, O, N> n = this; n.getParent() != null; n = n.getParent()) {
            path.addFirst(n.getCreator());
        }
        return new Solution<>(path);
    }

}
