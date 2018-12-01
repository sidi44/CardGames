package com.sidi.cardgames.framework;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Simon on 26/12/2017.
 */
public abstract class GameView implements Observer {

    public GameView(Game game) {
        game.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        updateView();
    }

    protected abstract void updateView();

}
