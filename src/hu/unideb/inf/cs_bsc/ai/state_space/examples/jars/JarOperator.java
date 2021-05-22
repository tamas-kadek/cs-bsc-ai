package hu.unideb.inf.cs_bsc.ai.state_space.examples.jars;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;

class JarOperator implements Operator<JarState> {

    final int i, j;
    final int[] max = {0, 5, 3, 2};

    public JarOperator(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean isApplicable(JarState jarState) {
        int[] a = jarState.a;
        return a[i] > 0 && a[j] < max[j];
    }

    @Override
    public JarState apply(JarState jarState) {
        JarState newState = new JarState();
        int[] a = jarState.a;
        int[] b = newState.a;
        int m = Math.min(a[i], max[j] - a[j]);
        for (int k = 1; k <= 3; k++) {
            if (k == i)
                b[k] = a[k] - m;
            else if (k == j)
                b[k] = a[k] + m;
            else
                b[k] = a[k];
        }
        return newState;
    }

    public String toString() {
        return "(" + i + " => " + j + ")";
    }

}
