package com.sidi.cardgames.patience.move;

/**
 * Created by Simon on 29/12/2017.
 */
public class DeckToFoundationPileMove implements PatienceMove {

    private int mTargetFoundationPile;

    public DeckToFoundationPileMove(int targetPile) {
        this.mTargetFoundationPile = targetPile;
    }

    public int getTargetFoundationPile() {
        return mTargetFoundationPile;
    }

    @Override
    public void accept(PatienceMoveVisitor visitor) {
        visitor.visit(this);
    }

}
