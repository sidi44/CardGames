package com.sidi.cardgames.card;

/**
 * Created by Simon on 26/12/2017.
 */
public enum Suit {
    Club(true, "C"),
    Diamond(false, "D"),
    Heart(false, "H"),
    Spade(true, "S");

    private final boolean mIsBlack;
    private final String mString;
    private Suit(boolean isBlack, String string) {
        this.mIsBlack = isBlack;
        this.mString = string;
    }
    public boolean isBlack() {
        return mIsBlack;
    }
    public String getString() {
        return mString;
    }
}
