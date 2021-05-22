package hu.unideb.inf.cs_bsc.ai.csp.algorithm;

import hu.unideb.inf.cs_bsc.ai.csp.representation.BinaryConstraint;
import hu.unideb.inf.cs_bsc.ai.csp.representation.Pair;
import hu.unideb.inf.cs_bsc.ai.csp.representation.Value;
import hu.unideb.inf.cs_bsc.ai.csp.representation.Variable;

import java.util.*;

public class AC4 {

    private static final Set<Value> EMPTY = new HashSet<>();

    public void run(Collection<BinaryConstraint<?, ?>> constraints) {

        Map<Value, Set<Value>> supports = new HashMap<>();
        Map<Pair<Value, Variable<?>>, Integer> counter = new HashMap<>();

        // init:
        LinkedList<Value> queue = new LinkedList<>();
        for (BinaryConstraint<?, ?> bc : constraints) {
            bc.supports(supports, counter);
        }

        counter.entrySet().stream()
                .filter(a -> a.getValue() == 0)
                .map(a -> a.getKey().left)
                .peek(Value::delete)
                .forEach(queue::add);

        while (!queue.isEmpty()) {
            Value m = queue.removeFirst();
            for (Value p : supports.getOrDefault(m, EMPTY)) {
                Pair<Value,Variable<?>> ck = Pair.of(p, m.getVariable());
                int count = counter.compute(ck, (k, v) -> (v - 1));
                if (count == 0) {
                    if (p.delete()) {
                        queue.add(p);
                    }
                }
            }
        }
    }

}
