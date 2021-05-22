package hu.unideb.inf.cs_bsc.ai.state_space.algorithms;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Problem;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.Successor;

import java.util.LinkedList;
import java.util.Optional;

public class RecursiveBackTrack<S extends State, O extends Operator<S>> implements Algorithm<S, O> {

    public Optional<Solution<S, O>> findSolution(Problem<S, O> problem) {
        LinkedList<O> result = run(problem.newStartState(), problem);
        return result == null ? Optional.empty() : Optional.of(new Solution<>(result));
    }

    private LinkedList<O> run(S current, Problem<S, O> problem) {
        if (current.isGoal()) {
            return new LinkedList<>();
        }
        for (Successor<S, O> successor : problem.getSuccessors(current)) {
            LinkedList<O> solution = run(successor.getState(), problem);
            if (solution != null) {
                solution.addFirst(successor.getCreator());
                return solution;
            }
        }
        return null;
    }

}
