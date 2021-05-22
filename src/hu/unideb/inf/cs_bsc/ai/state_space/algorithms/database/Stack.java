package hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database;

public class Stack<T> extends LinkedListFrontier<T> {

    @Override
    public void add(T node) {
        content.addLast(node);
    }

    @Override
    public T removeNext() {
        return content.removeLast();
    }

}