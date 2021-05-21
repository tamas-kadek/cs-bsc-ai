package hu.unideb.inf.cs_bsc.ai.csp.representation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class Variable<T> {

    private final ArrayList<T> wrapped = new ArrayList<>();

    private final Set<Value> values = new LinkedHashSet<>();

    private final String name;

    private Variable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Iterable<Value> values() {
        return new LinkedHashSet<>(values);
    }

    public boolean delete(Value value) {
        return values.remove(value);
    }

    public static <T> Variable<T> of(String name, Collection<T> domain) {
        Variable<T> result = new Variable<>(name);
        for (T w : domain) {
            result.values.add(new Value(result, result.wrapped.size()));
            result.wrapped.add(w);
        }
        return result;
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public T getWrapped(Value value) {
        return wrapped.get(value.index);
    }

}
