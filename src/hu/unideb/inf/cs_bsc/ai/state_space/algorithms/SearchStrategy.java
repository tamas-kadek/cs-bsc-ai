package hu.unideb.inf.cs_bsc.ai.state_space.algorithms;

import hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database.AbstractNode;
import hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database.Frontier;
import hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database.NodeBuilder;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Problem;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

public enum SearchStrategy {

    TREE_SEARCH {
        public <S extends State, O extends Operator<S>, N extends AbstractNode<S, O, N>> N findGoal(Problem<S, O> p, Supplier<Frontier<N>> frontierBuilder, NodeBuilder<S, O, N> nodeBuilder) {
            // DATABASE:
            Frontier<N> frontier = frontierBuilder.get();
            // CONTROLLER:
            // 1.
            frontier.add(nodeBuilder.buildFrom(p.newStartState()));
            while (true) {
                // 2.
                if (frontier.isEmpty()) {
                    return null;
                }
                // 3.
                N selected = frontier.removeNext();
                // 4.
                if (selected.isTerminal()) {
                    return selected;
                }
                // 5.
                for (N child : nodeBuilder.children(selected, p)) {
                    frontier.add(child);
                }
            }
        }
    },

    GRAPH_SEARCH {
        public <S extends State, O extends Operator<S>, N extends AbstractNode<S, O, N>> N findGoal(Problem<S, O> p, Supplier<Frontier<N>> frontierBuilder, NodeBuilder<S, O, N> nodeBuilder) {
            // DATABASE:
            Frontier<N> frontier = frontierBuilder.get();
            Set<S> explored = new HashSet<>();
            // CONTROLLER:
            // 1.
            frontier.add(nodeBuilder.buildFrom(p.newStartState()));
            while (true) {
                // 2.
                if (frontier.isEmpty()) {
                    return null;
                }
                // 3.
                N selected = frontier.removeNext();
                // 4.
                if (selected.isTerminal()) {
                    return selected;
                }
                // 5.
                if (!explored.contains(selected.getState())) {
                    explored.add(selected.getState());
                    for (N child : nodeBuilder.children(selected, p)) {
                        frontier.add(child);
                    }
                }
            }
        }
    };

    public abstract <S extends State, O extends Operator<S>, N extends AbstractNode<S, O, N>> N findGoal(Problem<S, O> p, Supplier<Frontier<N>> frontierBuilder, NodeBuilder<S, O, N> nodeBuilder);

    public <S extends State, O extends Operator<S>, N extends AbstractNode<S, O, N>> Optional<Solution<S, O>> findSolution(Problem<S, O> problem, Supplier<Frontier<N>> frontierBuilder, NodeBuilder<S, O, N> nodeBuilder) {
        N goal = findGoal(problem, frontierBuilder, nodeBuilder);
        return goal == null ? Optional.empty() : Optional.of(goal.toSolution());
    }

}
