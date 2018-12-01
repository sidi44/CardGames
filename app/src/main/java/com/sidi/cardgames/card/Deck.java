package com.sidi.cardgames.card;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Simon on 26/12/2017.
 */
public class Deck {

    LinkedList<Card> mCards;
    // We've specifically used LinkedList here as we want both list and deque behaviours.

    public Deck() {

        mCards = new LinkedList<Card>();

        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                mCards.add(new Card(suit, value));
            }
        }

        shuffle();
    }

    public void shuffle() {
        Random rand = new Random();
        Collections.shuffle(mCards, rand);
    }

    public Card deal() {
        if (!mCards.isEmpty()) {
            return mCards.remove();
        } else {
            return null;
        }
    }

    public void insertCardEnd(Card card) {
        mCards.addLast(card);
    }

    public int size() {
        return mCards.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
