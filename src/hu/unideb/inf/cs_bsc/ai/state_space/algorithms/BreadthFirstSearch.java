package hu.unideb.inf.cs_bsc.ai.state_space.algorithms;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Problem;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Successor;

import java.util.Optional;

public class BreadthFirstSearch<S extends State, O extends Operator<S>> implements Algorithm<S, O> {

    class Node extends AbstractNode<S, O, Node> {

        Node(S state, O creator, Node parent) {
            super(state, creator, parent);
        }

        @Override
        public Node newChild(Successor<S, O> successor) {
            return new Node(successor.getState(), successor.getCreator(), this);
        }

    }

    class Queue extends LinkedListFrontier<Node> {

        @Override
        public void add(Node node) {
            content.addLast(node);
        }

        @Override
        public Node removeNext() {
            return content.removeFirst();
        }

    }

    private final SearchStrategy strategy;

    public BreadthFirstSearch(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Optional<Solution<S, O>> findSolution(Problem<S, O> p) {
        Node start = new Node(p.newStartState(), null, null);
        Queue queue = new Queue();
        queue.add(start);
        Node goal = strategy.run(p, queue);
        return goal == null ? Optional.empty() : Optional.of(goal.toSolution());
    }

}
