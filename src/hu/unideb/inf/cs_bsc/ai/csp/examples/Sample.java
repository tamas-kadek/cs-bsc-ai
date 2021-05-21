package hu.unideb.inf.cs_bsc.ai.csp.examples;

import hu.unideb.inf.cs_bsc.ai.csp.algorithm.AC1;
import hu.unideb.inf.cs_bsc.ai.csp.algorithm.BackTrack;
import hu.unideb.inf.cs_bsc.ai.csp.representation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Sample {

    public static void main(String[] args) {
        Collection<Integer> domain = Arrays.asList(1, 2, 3);
        Variable<Integer> A = Variable.of("A", domain);
        Variable<Integer> B = Variable.of("B", domain);
        Variable<Integer> C = Variable.of("C", domain);
        Variable<Integer> D = Variable.of("D", domain);
        Variable<Integer> E = Variable.of("E", domain);

        ProblemBuilder pb = new ProblemBuilder()
                .add(BinaryConstraint.of(A, C, (a, c) -> a < c))
                .add(BinaryConstraint.of(C, D, (c, d) -> c + 1 == d))
                .add(BinaryConstraint.of(B, E, (b, e) -> (b == 3 * e)))
                .add(BinaryConstraint.of(A, B, (a, b) -> a * 3 == b));

        Problem p = pb.build();


        long time = System.currentTimeMillis();
        new AC1().run(p);
        if (!p.isInconsistent()) {
            List<Value> assignments = new BackTrack().run(p);
            if (assignments != null) {
                System.out.println(p.toString(Arrays.asList(A, B, C, D, E), assignments));
            }
        }
        System.out.println(System.currentTimeMillis() - time + " ms");
    }

}
