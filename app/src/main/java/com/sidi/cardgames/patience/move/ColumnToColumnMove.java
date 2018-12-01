package com.sidi.cardgames.patience.move;

/**
 * Created by Simon on 29/12/2017.
 */
public class ColumnToColumnMove implements PatienceMove {

    private int mSourceColumn;
    private int mTargetColumn;
    private int mNumCards;

    public ColumnToColumnMove(int source, int target, int numCards) {
        this.mSourceColumn = source;
        this.mTargetColumn = target;
        this.mNumCards = numCards;
    }

    public int getSourceColumn() {
        return mSourceColumn;
    }

    public int getTargetColumn() {
        return mTargetColumn;
    }

    public int getNumCards() {
        return mNumCards;
    }

    @Override
    public void accept(PatienceMoveVisitor visitor) {
        visitor.visit(this);
    }

}
