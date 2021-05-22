package hu.unideb.inf.cs_bsc.ai.state_space.examples.hanoi;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;

import java.util.Arrays;

class HanoiState implements State {

    final int a[];

    HanoiState(int n) {
        a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = 1;
    }

    HanoiState(HanoiState state) {
        a = new int[state.a.length];
    }

    @Override
    public boolean isGoal() {
        for (int i = 1; i <= a.length - 1; i++)
            if (a[i] != 3)
                return false;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HanoiState that = (HanoiState) o;
        return Arrays.equals(a, that.a);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(a);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < a.length; i++)
            builder.append(i == 1 ? "(" : ",").append(a[i]);
        return builder.append(")").toString();
    }
}
