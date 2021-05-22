package hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Problem;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Successor;

import java.util.ArrayList;

public interface NodeBuilder<S extends State, O extends Operator<S>, N extends AbstractNode<S, O, N>> {

    N buildFrom(S start);

    N buildFrom(N node, Successor<S, O> success);

    default Iterable<N> children(N node, Problem<S, O> problem) {
        ArrayList<N> children = new ArrayList<>();
        for (Successor<S, O> successor : problem.getSuccessors(node.getState()))
            children.add(buildFrom(node, successor));
        return children;
    }

}
