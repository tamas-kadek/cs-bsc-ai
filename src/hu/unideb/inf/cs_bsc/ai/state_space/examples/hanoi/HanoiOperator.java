package hu.unideb.inf.cs_bsc.ai.state_space.examples.hanoi;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;

class HanoiOperator implements Operator<HanoiState> {

    private final int i;
    private final int j;
    private final int k;

    HanoiOperator(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    private static int top(HanoiState state, int r) {
        int a[] = state.a;
        for (int l = 1; l < a.length; l++)
            if (a[l] == r)
                return l;
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isApplicable(HanoiState state) {
        return top(state, i) == k && k < top(state, j);
    }

    @Override
    public HanoiState apply(HanoiState state) {
        HanoiState newState = new HanoiState(state);
        int a[] = state.a;
        int b[] = newState.a;

        for (int l = 1; l < a.length; l++)
            b[l] = (l == k) ? j : a[l];

        return newState;
    }

    @Override
    public String toString() {
        return k + ": " + i + " -> " + j;
    }

}
