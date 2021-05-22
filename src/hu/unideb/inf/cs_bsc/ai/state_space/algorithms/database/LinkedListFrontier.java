package hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database;

import java.util.LinkedList;

abstract class LinkedListFrontier<N> implements Frontier<N> {

    protected final LinkedList<N> content = new LinkedList<>();

    public boolean isEmpty() {
        return content.isEmpty();
    }

}
