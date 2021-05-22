package hu.unideb.inf.cs_bsc.ai.state_space.examples.jars;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;

import java.util.Arrays;

class JarState implements State {

    int[] a = new int[4];

    @Override
    public boolean isGoal() {
        return a[1] == 4;
    }

    @Override
    public String toString() {
        return "(" + a[1] + "," + a[2] + "," + a[3] + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof JarState) {
            return Arrays.equals(this.a, ((JarState) obj).a);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return a[1] * 100 + a[2] * 10 + a[3];
    }
}
