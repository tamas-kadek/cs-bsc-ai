package hu.unideb.inf.cs_bsc.ai.state_space.algorithms;

import hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database.DepthLimitedNode;
import hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database.NodeBuilder;
import hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database.Stack;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Problem;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Successor;

import java.util.Arrays;
import java.util.Optional;

public class DepthLimited<S extends State, O extends Operator<S>> implements Algorithm<S, O> {

    private class LimitedNodeBuilder implements hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database.NodeBuilder<S, O, DepthLimitedNode<S, O>> {

        private final Iterable<DepthLimitedNode<S, O>> EMPTY = Arrays.asList();

        @Override
        public DepthLimitedNode<S, O> buildFrom(S start) {
            return new DepthLimitedNode<S, O>(start, null, null, 0);
        }

        @Override
        public DepthLimitedNode<S, O> buildFrom(DepthLimitedNode<S, O> parent, Successor<S, O> success) {
            int depth = parent.getDepth() + 1;
            return new DepthLimitedNode<S, O>(success.getState(), success.getCreator(), parent, depth);
        }

        @Override
        public Iterable<DepthLimitedNode<S, O>> children(DepthLimitedNode<S, O> node, Problem<S, O> problem) {
            if (node.getDepth() < limit)
                return NodeBuilder.super.children(node, problem);
            else
                return EMPTY;
        }
    }

    private final int limit;

    public DepthLimited(int limit) {
        this.limit = limit;
    }

    @Override
    public Optional<Solution<S, O>> findSolution(Problem<S, O> p) {
        return SearchStrategy.TREE_SEARCH.findSolution(p, Stack::new, new LimitedNodeBuilder());
    }

}
