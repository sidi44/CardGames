package com.sidi.cardgames.patience.move;

/**
 * Created by Simon on 29/12/2017.
 */
public class QuitGameMove implements PatienceMove {

    @Override
    public void accept(PatienceMoveVisitor visitor) {
        visitor.visit(this);
    }

}
