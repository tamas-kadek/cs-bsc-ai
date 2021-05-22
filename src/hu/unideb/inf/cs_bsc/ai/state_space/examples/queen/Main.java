package hu.unideb.inf.cs_bsc.ai.state_space.examples.queen;

import hu.unideb.inf.cs_bsc.ai.state_space.algorithms.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        QueenProblem problem = new QueenProblem(8);

        List<Algorithm<QueenState, QueenOperator>> algorithms = new ArrayList<>();
        algorithms.add(new DepthFirstSearch<>(SearchStrategy.TREE_SEARCH));
        algorithms.add(new BreadthFirstSearch<>(SearchStrategy.TREE_SEARCH));
        algorithms.add(new RecursiveBackTrack<>());
        algorithms.add(new IterativeDeepening<>());

        for (Algorithm<QueenState, QueenOperator> algorithm: algorithms) {
            System.out.println(algorithm.getClass().getSimpleName());
            Optional<Solution<QueenState, QueenOperator>> solution = algorithm.findSolution(problem);
            solution.ifPresent(System.out::println);
        }
    }

}
