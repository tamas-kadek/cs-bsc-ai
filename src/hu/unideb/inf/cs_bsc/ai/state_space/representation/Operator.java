package hu.unideb.inf.cs_bsc.ai.state_space.representation;

public interface Operator<S extends State> {

    boolean isApplicable(S s);

    S apply(S s);

}
