package com.sidi.cardgames.patience.move;

/**
 * Created by Simon on 29/12/2017.
 */
public interface PatienceMoveVisitor {

    public abstract void visit(AdvanceDeckMove move);

    public abstract void visit(ColumnToColumnMove move);

    public abstract void visit(ColumnToFoundationPileMove move);

    public abstract void visit(DeckToColumnMove move);

    public abstract void visit(DeckToFoundationPileMove move);

    public abstract void visit(QuitGameMove move);

}
