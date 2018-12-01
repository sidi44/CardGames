package com.sidi.cardgames.framework;

import java.util.Observable;

/**
 * Created by Simon on 26/12/2017.
 */
public abstract class Game extends Observable {

    public abstract void nextMove(Move move);

    public abstract boolean gameOver();

    public abstract boolean gameWon();
}
