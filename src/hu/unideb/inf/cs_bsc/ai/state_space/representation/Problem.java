package hu.unideb.inf.cs_bsc.ai.state_space.representation;

public interface Problem<S extends State, O extends Operator<S>> {

    S newStartState();

    Iterable<Successor<S, O>> getSuccessors(S state);

}
