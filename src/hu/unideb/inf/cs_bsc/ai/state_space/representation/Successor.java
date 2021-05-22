package hu.unideb.inf.cs_bsc.ai.state_space.representation;

public class Successor<S extends State, O extends Operator<S>> {

    O creator;

    S state;

    public Successor(S state, O creator) {
        this.state = state;
        this.creator = creator;
    }

    public O getCreator() {
        return creator;
    }

    public S getState() {
        return state;
    }

}
