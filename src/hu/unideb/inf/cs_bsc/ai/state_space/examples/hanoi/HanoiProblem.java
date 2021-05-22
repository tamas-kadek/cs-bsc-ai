package hu.unideb.inf.cs_bsc.ai.state_space.examples.hanoi;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.AbstractProblem;

import java.util.ArrayList;
import java.util.List;

class HanoiProblem extends AbstractProblem<HanoiState, HanoiOperator> {

    private final int n;

    public HanoiProblem(int n) {
        super(operators(n));
        this.n = n;
    }

    private static List<HanoiOperator> operators(int n) {
        List<HanoiOperator> operators = new ArrayList<>();
        for (int i = 1; i <= 3; i++)
            for (int j = 1; j <= 3; j++)
                if (i != j)
                    for (int k = 1; k <= n; k++)
                        operators.add(new HanoiOperator(i, j, k));
        return operators;
    }

    @Override
    public HanoiState newStartState() {
        return new HanoiState(n);
    }

}
