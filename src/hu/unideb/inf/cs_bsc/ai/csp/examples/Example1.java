package hu.unideb.inf.cs_bsc.ai.csp.examples;

import hu.unideb.inf.cs_bsc.ai.csp.algorithm.AC1;
import hu.unideb.inf.cs_bsc.ai.csp.algorithm.BackTrack;
import hu.unideb.inf.cs_bsc.ai.csp.representation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Example1 {

    public static void main(String[] args) {
        Collection<Integer> domain = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Variable<Integer> A = Variable.of("A", domain);
        Variable<Integer> B = Variable.of("B", domain);
        Variable<Integer> C = Variable.of("C", domain);
        Variable<Integer> D = Variable.of("D", domain);
        Variable<Integer> E = Variable.of("E", domain);
        Variable<Integer> F = Variable.of("F", domain);

        ProblemBuilder pb = new ProblemBuilder()
                .add(BinaryConstraint.of(A, C, (a, c) -> a < c + 1))
                .add(BinaryConstraint.of(C, D, (c, d) -> c < d))
                .add(BinaryConstraint.of(B, E, (b, e) -> (b == 3 * e - 1)))
                .add(BinaryConstraint.of(D, F, (d, f) -> d < f))
                .add(BinaryConstraint.of(A, B, (a, b) -> a < b))
                .add(BinaryConstraint.of(F, A, (f, a) -> f == 2 * a));

        Problem p = pb.build();


        long time = System.currentTimeMillis();
        new AC1().run(p);
        if (!p.isInconsistent()) {
            List<Value> assignments = new BackTrack().run(p);
            if (assignments != null) {
                System.out.println(p.toString(Arrays.asList(A, B, C, D, E, F), assignments));
            }
        }
        System.out.println(System.currentTimeMillis() - time + " ms");
    }

}
