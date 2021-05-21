package hu.unideb.inf.cs_bsc.ai.csp.algorithm;

import hu.unideb.inf.cs_bsc.ai.csp.representation.BinaryConstraint;

import java.util.ArrayList;
import java.util.Collection;

public class AC1 {

    public void run(Collection<BinaryConstraint<?, ?>> constraints) {
        ArrayList<BinaryConstraint<?, ?>> workingSet = new ArrayList<>(constraints);

        boolean change;
        do {
            change = false;
            for (BinaryConstraint<?, ?> constraint : constraints) {
                change |= constraint.revise();
            }
        } while (change);
    }

}
