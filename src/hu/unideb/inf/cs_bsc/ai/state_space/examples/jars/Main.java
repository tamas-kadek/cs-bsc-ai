package hu.unideb.inf.cs_bsc.ai.state_space.examples.jars;

import hu.unideb.inf.cs_bsc.ai.state_space.algorithms.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static hu.unideb.inf.cs_bsc.ai.state_space.algorithms.SearchStrategy.TREE_SEARCH;

public class Main {

    public static void main(String[] args) {
        JarProblem problem = new JarProblem();

        List<Algorithm<JarState, JarOperator>> algorithms = new ArrayList<>();
        algorithms.add(new DepthFirstSearch<>(SearchStrategy.GRAPH_SEARCH));
        algorithms.add(new IterativeDeepening<>());

        for ( Algorithm algorithm: algorithms ) {
            Optional<Solution<JarState, JarOperator>> solution = algorithm.findSolution(problem);
            if (solution.isPresent()) {
                System.out.println(solution.get());
            }
        }

    }

}
