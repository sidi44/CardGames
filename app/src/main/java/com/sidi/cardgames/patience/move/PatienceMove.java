package com.sidi.cardgames.patience.move;

import com.sidi.cardgames.framework.Move;

/**
 * Created by Simon on 29/12/2017.
 */
public interface PatienceMove extends Move {

    public abstract void accept(PatienceMoveVisitor visitor);

}
