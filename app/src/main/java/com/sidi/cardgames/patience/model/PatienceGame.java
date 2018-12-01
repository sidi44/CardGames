package com.sidi.cardgames.patience.model;

import com.sidi.cardgames.framework.Game;
import com.sidi.cardgames.framework.Move;
import com.sidi.cardgames.patience.move.PatienceMove;

/**
 * Created by Simon on 29/12/2017.
 */

public class PatienceGame extends Game {

    private PatienceGameState mGameState;

    public PatienceGame() {
        mGameState = new PatienceGameState();
    }

    @Override
    public void nextMove(Move move) {
        PatienceMove patienceMove = (PatienceMove) move;
        PatienceMoveHandler moveHandler = new PatienceMoveHandler(mGameState);
        patienceMove.accept(moveHandler);

        if (!moveHandler.getMoveSuccess()) {
            System.out.println("Move failed.");
        }

        setChanged();
        notifyObservers();
    }

    @Override
    public boolean gameOver() {
        return mGameState.getGameQuit() || gameWon();
    }

    @Override
    public boolean gameWon() {
        return mGameState.gameWon();
    }

    public PatienceGameState getGameState() {
        return mGameState;
    }
}
