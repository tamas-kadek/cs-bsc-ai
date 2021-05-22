package hu.unideb.inf.cs_bsc.ai.state_space.representation;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractProblem<S extends State, O extends Operator<S>> implements Problem<S, O> {

    final List<O> operators;

    protected AbstractProblem(List<O> operators) {
        this.operators = operators;
    }

    @Override
    public Iterable<Successor<S, O>> getSuccessors(S state) {
        List<Successor<S, O>> successors = new ArrayList<>();
        for (O op : operators) {
            if (op.isApplicable(state)) {
                successors.add(new Successor<>(op.apply(state), op));
            }
        }
        return successors;
    }

}
