package hu.unideb.inf.cs_bsc.ai.state_space.examples.queen;

import hu.unideb.inf.cs_bsc.ai.state_space.representation.Operator;

class QueenOperator implements Operator<QueenState> {

    private final int row;

    protected QueenOperator(int row) {
        this.row = row;
    }

    @Override
    public boolean isApplicable(QueenState state) {
        for (int column = 1; column < state.getNextColumn(); column++) {
            if (state.getRowIndex(column) == row)
                return false;
            if (Math.abs(state.getRowIndex(column) - row) == Math.abs(state.getNextColumn() - column))
                return false;
        }
        return true;
    }

    @Override
    public QueenState apply(QueenState state) {
        QueenState result = new QueenState(state);
        for (int column = 1; column < state.getNextColumn(); column++)
            result.setRowIndex(column, state.getRowIndex(column));
        result.setRowIndex(state.getNextColumn(), row);
        result.setNextColumn(state.getNextColumn() + 1);
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(row);
    }
}
