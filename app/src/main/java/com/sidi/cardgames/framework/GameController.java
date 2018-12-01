package com.sidi.cardgames.framework;

/**
 * Created by Simon on 26/12/2017.
 */
public class GameController {

    private Game mGame;
    private GameView mView;

    public GameController(Game game, GameView view) {
        this.mGame = game;
        this.mView = view;
    }

    public void startGame() {
        mView.update(mGame, null);
    }

    public void nextMove(Move move) {

        // Do the move
        mGame.nextMove(move);

        // Update the view
        mView.update(mGame, null);
    }

    public boolean gameOver() {
        return mGame.gameOver();
    }

    public boolean gameWon() {
        return mGame.gameWon();
    }
}
