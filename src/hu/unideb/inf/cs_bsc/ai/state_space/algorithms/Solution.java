package hu.unideb.inf.cs_bsc.ai.state_space.algorithms;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;
import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;

import java.util.Iterator;
import java.util.List;

public class Solution<S extends State, O extends Operator<S>> implements Iterable<O> {

    List<O> operators;

    Solution(List<O> operators) {
        this.operators = operators;
    }

    @Override
    public Iterator<O> iterator() {
        return operators.iterator();
    }

}
