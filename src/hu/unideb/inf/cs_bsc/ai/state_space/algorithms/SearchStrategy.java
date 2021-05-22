package hu.unideb.inf.cs_bsc.ai.state_space.algorithms;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Problem;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Successor;

import java.util.HashSet;
import java.util.Set;

public enum SearchStrategy {

    TREE_SEARCH {
        public <S extends State, O extends Operator<S>, N extends AbstractNode<S, O, N>> N run(Problem<S, O> p, Frontier<N> frontier) {
            // CONTROLLER:
            // Supposing that the frontier has initialized with the help of the start state
            while (true) {
                // 2.
                if (frontier.isEmpty()) {
                    return null;
                }
                // 3.
                N selected = frontier.removeNext();
                // 4.
                if (selected.getState().isGoal()) {
                    return selected;
                }
                // 5.
                for (Successor<S, O> successor : p.getSuccessors(selected.getState())) {
                    frontier.add(selected.newChild(successor));
                }
            }
        }
    },

    GRAPH_SEARCH {
        public <S extends State, O extends Operator<S>, N extends AbstractNode<S, O, N>> N run(Problem<S, O> p, Frontier<N> frontier) {
            Set<S> explored = new HashSet<>();
            // CONTROLLER:
            // Supposing that the frontier has initialized with the help of the start state
            while (true) {
                // 2.
                if (frontier.isEmpty()) {
                    return null;
                }
                // 3.
                N selected = frontier.removeNext();
                // 4.
                if (selected.getState().isGoal()) {
                    return selected;
                }
                // 5.
                if (!explored.contains(selected.getState())) {
                    explored.add(selected.getState());
                    for (Successor<S, O> successor : p.getSuccessors(selected.getState())) {
                        frontier.add(selected.newChild(successor));
                    }
                }
            }
        }
    };

    public abstract <S extends State, O extends Operator<S>, N extends AbstractNode<S, O, N>> N run(Problem<S, O> p, Frontier<N> frontier);

}
