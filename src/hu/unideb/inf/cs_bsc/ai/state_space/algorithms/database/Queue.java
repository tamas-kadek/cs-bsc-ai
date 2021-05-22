package hu.unideb.inf.cs_bsc.ai.state_space.algorithms.database;

public class Queue<T> extends LinkedListFrontier<T> {

    @Override
    public void add(T node) {
        content.addLast(node);
    }

    @Override
    public T removeNext() {
        return content.removeFirst();
    }


}
