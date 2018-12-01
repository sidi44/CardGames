package com.sidi.cardgames.patience.model;

import com.sidi.cardgames.patience.move.AdvanceDeckMove;
import com.sidi.cardgames.patience.move.ColumnToColumnMove;
import com.sidi.cardgames.patience.move.ColumnToFoundationPileMove;
import com.sidi.cardgames.patience.move.DeckToColumnMove;
import com.sidi.cardgames.patience.move.DeckToFoundationPileMove;
import com.sidi.cardgames.patience.move.PatienceMoveVisitor;
import com.sidi.cardgames.patience.move.QuitGameMove;

/**
 * Created by Simon on 29/12/2017.
 */
public class PatienceMoveHandler implements PatienceMoveVisitor {

    private PatienceGameState mGameState;
    private boolean mMoveSuccess;

    public PatienceMoveHandler(PatienceGameState gameState) {
        this.mGameState = gameState;
        this.mMoveSuccess = false;
    }

    public boolean getMoveSuccess() {
        return mMoveSuccess;
    }

    @Override
    public void visit(AdvanceDeckMove move) {
        mGameState.advanceDeck();
        mMoveSuccess = true;
    }

    @Override
    public void visit(ColumnToColumnMove move) {
        mMoveSuccess =
                mGameState.moveColumnToColumn(
                        move.getSourceColumn(),
                        move.getTargetColumn(),
                        move.getNumCards()
                );
    }

    @Override
    public void visit(ColumnToFoundationPileMove move) {
        mMoveSuccess =
                mGameState.moveColumnToFoundationPile(
                        move.getSourceColumn(),
                        move.getTargetFoundationPile()
                );
    }

    @Override
    public void visit(DeckToColumnMove move) {
        mMoveSuccess = mGameState.moveSideDeckToColumn(move.getTargetColumn());
    }

    @Override
    public void visit(DeckToFoundationPileMove move) {
        mMoveSuccess =
                mGameState.moveSideDeckToFoundationPile(
                        move.getTargetFoundationPile()
                );
    }

    @Override
    public void visit(QuitGameMove move) {
        mGameState.quitGame();
        mMoveSuccess = true;
    }
}
