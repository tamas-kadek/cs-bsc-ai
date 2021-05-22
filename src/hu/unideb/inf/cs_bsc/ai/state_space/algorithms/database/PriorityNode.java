package hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;

public class PriorityNode<S extends State, O extends Operator<S>> extends AbstractNode<S, O, PriorityNode<S, O>> {

    private final double evaluation;

    public PriorityNode(S state, O operator, PriorityNode<S, O> parent, double evaluation) {
        super(state, operator, parent);
        this.evaluation = evaluation;
    }

    public double getEvaluation() {
        return evaluation;
    }

}
