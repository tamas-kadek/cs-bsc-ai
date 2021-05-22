package hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class PriorityQueue<N> extends LinkedListFrontier<N> {

    private final EvaluationFunction<N> evaluationFunction;

    public PriorityQueue(EvaluationFunction<N> evaluationFunction) {
        this.evaluationFunction = evaluationFunction;
    }

    @Override
    public void add(N node) {
        content.add(node);
    }

    @Override
    public N removeNext() {
        Comparator<N> comparator = Comparator.comparingDouble(evaluationFunction::evaluate);
        Optional<N> min = content.stream().min(comparator);
        if (!min.isPresent())
            throw new NoSuchElementException("Cannot remove nodes from an empty frontier!");
        N result = min.get();
        content.remove(result);
        return result;
    }

}