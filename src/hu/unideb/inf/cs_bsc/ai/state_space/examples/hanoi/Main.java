package hu.unideb.inf.cs_bsc.ai.state_space.examples.hanoi;

import hu.unideb.inf.cs_bsc.ai.state_space.algorithms.Algorithm;
import hu.unideb.inf.cs_bsc.ai.state_space.algorithms.BreadthFirstSearch;
import hu.unideb.inf.cs_bsc.ai.state_space.algorithms.Solution;

import java.util.Optional;

import static hu.unideb.inf.cs_bsc.ai.state_space.algorithms.SearchStrategy.GRAPH_SEARCH;

public class Main {

    public static void main(String[] args) {
        HanoiProblem problem = new HanoiProblem(4);
        Algorithm<HanoiState, HanoiOperator> algorithm = new BreadthFirstSearch(GRAPH_SEARCH);
        Optional<Solution<HanoiState, HanoiOperator>> solution = algorithm.findSolution(problem);
        if (solution.isPresent()) {
            HanoiState state = problem.newStartState();
            for (HanoiOperator operator : solution.get()) {
                System.out.println(state);
                System.out.println(operator);
                state = operator.apply(state);
            }
            System.out.println(state);
        }

    }

}
