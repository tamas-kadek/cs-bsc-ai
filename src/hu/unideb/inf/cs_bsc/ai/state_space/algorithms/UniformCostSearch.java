package hu.unideb.inf.cs_bsc.ai.state_space.algorithms;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Problem;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Successor;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class UniformCostSearch<S extends State, O extends Operator<S>> implements Algorithm<S, O> {

    private class Node extends AbstractNode<S, O, Node> {

        private final EdgeCost<S, O> edgeCost;

        private final double pathCost;

        public double getPathCost() {
            return pathCost;
        }

        Node(S start, EdgeCost<S, O> edgeCost) {
            super(start, null, null);
            this.edgeCost = edgeCost;
            this.pathCost = 0;
        }

        Node(S state, O creator, Node parent) {
            super(state, creator, parent);
            this.edgeCost = parent.edgeCost;
            this.pathCost = parent.pathCost + edgeCost.cost(parent.getState(), creator);
        }

        @Override
        public Node newChild(Successor<S, O> successor) {
            return new Node(successor.getState(), successor.getCreator(), this);
        }

    }

    private class PriorityQueue extends LinkedListFrontier<Node> {

        @Override
        public void add(Node node) {
            content.add(node);
        }

        @Override
        public Node removeNext() {
            Optional<Node> min = content.stream().min(Comparator.comparingDouble(Node::getPathCost));
            if (!min.isPresent())
                throw new NoSuchElementException("Cannot remove nodes from an empty frontier!");
            Node result = min.get();
            content.remove(result);
            return result;
        }

    }

    private final SearchStrategy strategy;

    private final EdgeCost<S, O> edgeCost;

    public UniformCostSearch(SearchStrategy strategy, EdgeCost<S, O> edgeCost) {
        this.strategy = strategy;
        this.edgeCost = edgeCost;
    }

    @Override
    public Optional<Solution<S, O>> findSolution(Problem<S, O> p) {
        Node start = new Node(p.newStartState(), edgeCost);
        PriorityQueue frontier = new PriorityQueue();
        frontier.add(start);
        Node goal = strategy.run(p, frontier);
        return goal == null ? Optional.empty() : Optional.of(goal.toSolution());
    }

}
