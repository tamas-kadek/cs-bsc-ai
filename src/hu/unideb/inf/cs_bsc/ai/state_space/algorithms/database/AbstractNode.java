package hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database;

import hu.unideb.inf.cs_bsc.ai.state_space.algorithms.Solution;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;

import java.util.LinkedList;

public abstract class AbstractNode<S extends State, O extends Operator<S>, N extends AbstractNode<S, O, N>> {

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

    public boolean isTerminal() {
        return state.isGoal();
    }

    public Solution<S, O> toSolution() {
        LinkedList<O> path = new LinkedList<>();
        for (AbstractNode<S, O, N> n = this; n.getParent() != null; n = n.getParent()) {
            path.addFirst(n.getCreator());
        }
        return new Solution<>(path);
    }

}
