package com.sidi.cardgames.patience.move;

/**
 * Created by Simon on 29/12/2017.
 */
public class DeckToColumnMove implements PatienceMove {

    private int mTargetColumn;

    public DeckToColumnMove(int targetColumn) {
        this.mTargetColumn = targetColumn;
    }

    public int getTargetColumn() {
        return mTargetColumn;
    }

    @Override
    public void accept(PatienceMoveVisitor visitor) {
        visitor.visit(this);
    }

}
