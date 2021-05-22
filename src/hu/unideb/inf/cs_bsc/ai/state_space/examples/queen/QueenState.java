package hu.unideb.inf.cs_bsc.ai.state_space.examples.queen;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.State;

class QueenState implements State {

    final int rowIndexes[];

    int getNextColumn() {
        return rowIndexes[0];
    }

    void setNextColumn(int column) {
        if (column < 1 || column > rowIndexes.length)
            throw new IndexOutOfBoundsException();
        rowIndexes[0] = column;
    }

    int getRowIndex(int column) {
        if (column < 1 || column >= rowIndexes.length)
            throw new IndexOutOfBoundsException();
        return rowIndexes[column];
    }

    void setRowIndex(int column, int row) {
        if (column < 1 || column >= rowIndexes.length)
            throw new IndexOutOfBoundsException();
        rowIndexes[column] = row;
    }

    public QueenState(int n) {
        this.rowIndexes = new int[n + 1];
        this.rowIndexes[0] = 1;
    }

    public QueenState(QueenState state) {
        this(state.rowIndexes.length - 1);
    }

    @Override
    public boolean isGoal() {
        return getNextColumn() == rowIndexes.length;
    }

}
