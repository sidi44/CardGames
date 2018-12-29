package com.sidi.cardgames.card;

/**
 * Created by Simon on 26/12/2017.
 */
public class Card {

    private Suit mSuit;
    private Value mValue;
    private boolean mFaceUp;

    public Card(Suit suit, Value value) {
        this.mSuit = suit;
        this.mValue = value;
        this.mFaceUp = false;
    }

    public Suit getSuit() {
        return mSuit;
    }

    public Value getValue() {
        return mValue;
    }

    public boolean isFaceUp() {
        return mFaceUp;
    }

    public void setFaceUp(boolean isFaceUp) {
        mFaceUp = isFaceUp;
    }

    public String toString() {

        String string = null;
        if (isFaceUp()) {
            string = mSuit.getString() + mValue.getString();
        } else {
            string = "???";
        }

        // Pad with spaces until we have something of length 3
        while (string.length() < 3) {
            string = " " + string;
        }

        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (mSuit != card.mSuit) return false;
        return mValue == card.mValue;
    }

    @Override
    public int hashCode() {
        int result = mSuit.hashCode();
        result = 31 * result + mValue.hashCode();
        return result;
    }
}
