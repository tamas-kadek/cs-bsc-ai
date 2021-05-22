package hu.unideb.inf.cs_bsc.ai.state_space.examples.queen;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.AbstractProblem;

import java.util.ArrayList;
import java.util.List;

class QueenProblem extends AbstractProblem<QueenState, QueenOperator> {

    private final int size;

    private static List<QueenOperator> generateOperators(int n) {
        ArrayList<QueenOperator> operators = new ArrayList<>();
        for (int row = 1; row <= n; row++)
            operators.add(new QueenOperator(row));
        return operators;
    }

    public QueenProblem(int size) {
        super(generateOperators(size));
        this.size = size;
    }

    @Override
    public QueenState newStartState() {
        return new QueenState(size);
    }

}



