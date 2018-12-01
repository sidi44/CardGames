package com.sidi.cardgames.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Simon on 26/12/2017.
 */
public class FoundationPile {

    private Suit mSuit;
    private List<Card> mCards;

    // Specifically state the order of cards a foundation pile expects
    // cards to be placed in. This way we're not relying on the order in
    // the enum class.
    private static final List<Value> REQUIRED_ORDER = Collections.unmodifiableList(
            Arrays.asList(
                    Value.Ace,
                    Value.Two,
                    Value.Three,
                    Value.Four,
                    Value.Five,
                    Value.Six,
                    Value.Seven,
                    Value.Eight,
                    Value.Nine,
                    Value.Ten,
                    Value.Jack,
                    Value.Queen,
                    Value.King
            )
    );

    public FoundationPile(Suit suit) {
        mSuit = suit;
        mCards = new ArrayList<Card>();
    }

    public Suit getSuit() {
        return mSuit;
    }

    public Card getTopCard() {
        if (!mCards.isEmpty()) {
            return mCards.get(mCards.size() - 1);
        } else {
            return null;
        }
    }

    public boolean addCard(Card card) {

        if (canAdd(card)) {
            mCards.add(card);
            return true;
        } else {
            return false;
        }

    }

    public boolean canAdd(Card card) {
        Value value = getNextValue();
        return (card.getSuit() == mSuit && card.getValue() == value);
    }

    public boolean empty() {
        return mCards.isEmpty();
    }

    public boolean complete() {
        return (mCards.size() == REQUIRED_ORDER.size());
    }

    private Value getNextValue() {

        Value value = null;
        if (!complete()) {
            int currentSize = mCards.size();
            value = REQUIRED_ORDER.get(currentSize);
        }

        return value;
    }

}
