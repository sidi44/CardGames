package com.sidi.cardgames.patience.move;

/**
 * Created by Simon on 29/12/2017.
 */
public class ColumnToFoundationPileMove implements PatienceMove {

    private int mSourceColumn;
    private int mFoundationPileTarget;

    public ColumnToFoundationPileMove(int sourceColumn, int targetPile) {
        this.mSourceColumn = sourceColumn;
        this.mFoundationPileTarget = targetPile;
    }

    public int getSourceColumn() {
        return mSourceColumn;
    }

    public int getTargetFoundationPile() {
        return mFoundationPileTarget;
    }

    @Override
    public void accept(PatienceMoveVisitor visitor) {
        visitor.visit(this);
    }

}
