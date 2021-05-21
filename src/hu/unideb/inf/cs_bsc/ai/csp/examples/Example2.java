package hu.unideb.inf.cs_bsc.ai.csp.examples;

import hu.unideb.inf.cs_bsc.ai.csp.algorithm.AC3;
import hu.unideb.inf.cs_bsc.ai.csp.algorithm.BackTrack;
import hu.unideb.inf.cs_bsc.ai.csp.representation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Example2 {

    public static void main(String[] args) {
        Collection<Integer> domain = Arrays.asList(1, 2, 3, 4);
        List<Pair<Integer, Integer>> domainD = new ArrayList<>();

        for (int i : domain)
            for (int j : domain)
                domainD.add(Pair.of(i, j));

        Variable<Integer> A = Variable.of("A", domain);
        Variable<Integer> B = Variable.of("B", domain);
        Variable<Integer> C = Variable.of("C", domain);
        Variable<Pair<Integer, Integer>> D = Variable.of("D", domainD);

        // a+b+c = 6
        //     a < b
        //     b < c
        // d1 = a
        // d2 = b
        // d1+d2+c = 6

        ProblemBuilder pb = new ProblemBuilder()
                .add(BinaryConstraint.of(A, D, (a, d) -> a.equals(d.left)))
                .add(BinaryConstraint.of(B, D, (b, d) -> b.equals(d.right)))
                .add(BinaryConstraint.of(A, B, (a, b) -> a < b))
                .add(BinaryConstraint.of(B, C, (b, c) -> b < c))
                .add(BinaryConstraint.of(C, D, (c, d) -> c + d.left + d.right == 6));

        Problem p = pb.build();
        new AC3().run(p);

        if (!p.isInconsistent()) {
            List<Value> assignments = new BackTrack().run(p);
            if (assignments != null) {
                System.out.println(p.toString(Arrays.asList(A, B, C, D), assignments));
            }
        }

    }

}
