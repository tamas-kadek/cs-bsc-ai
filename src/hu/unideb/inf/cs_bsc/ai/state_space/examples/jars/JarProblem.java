package hu.unideb.inf.cs_bsc.ai.state_space.examples.jars;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.AbstractProblem;

import java.util.ArrayList;
import java.util.List;

class JarProblem extends AbstractProblem<JarState, JarOperator> {

    private static final List<JarOperator> operators = new ArrayList<>();

    static {
        for (int i = 1; i <= 3; i++)
            for (int j = 1; j <= 3; j++)
                if (i != j) {
                    operators.add(new JarOperator(i, j));
                }
    }


    public JarProblem() {
        super(operators);
    }


    @Override
    public JarState newStartState() {
        JarState start = new JarState();
        start.a[1] = 5;
        start.a[2] = 0;
        start.a[3] = 0;
        return start;
    }

}
