package com.sidi.cardgames.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Simon on 26/12/2017.
 */
public class CardColumn {

    private LinkedList<Card> mCards;

    private static final List<Value> REQUIRED_ORDER = Collections.unmodifiableList(
            Arrays.asList(
                    Value.King,
                    Value.Queen,
                    Value.Jack,
                    Value.Ten,
                    Value.Nine,
                    Value.Eight,
                    Value.Seven,
                    Value.Six,
                    Value.Five,
                    Value.Four,
                    Value.Three,
                    Value.Two,
                    Value.Ace
            )
    );

    public CardColumn() {
        this.mCards = new LinkedList<Card>();
    }

    public boolean empty() {
        return mCards.isEmpty();
    }

    public int size() {
        return mCards.size();
    }

    public void dealCard(Card card) {

        if (card.isFaceUp()) {
            System.err.println("Expected cards to be dealt face down.");
        }

        mCards.add(card);
    }

    public boolean appendCard(Card card) {

        if (canAdd(card)) {
            push(card);
            return true;
        } else {
            return false;
        }

    }

    public boolean appendColumn(CardColumn column) {

        if (canAdd(column)) {
            while (!column.empty()) {
                push(column.popLast());
            }
            return true;
        }

        return false;
    }

    /**
     * Returns, but does not remove, the card at the top of the stack (which
     * is the 0th element of the list).
     *
     * @return
     */
    public Card peek() {
        return mCards.peek();
    }

    public Card peekLast() {
        return mCards.peekLast();
    }

    public Card peek(int index) {
        if (index >= 0 && index < mCards.size()) {
            return mCards.get(index);
        } else {
            return null;
        }
    }

    public Card pop() {
        return mCards.pop();
    }

    public Card popLast() {
        return mCards.removeLast();
    }

    // Private as callers should use appendCard() or appendColumn().
    private void push(Card card) {
        mCards.push(card);
    }

    public CardColumn peekSubColumn(int num) {
        CardColumn subColumn = new CardColumn();

        if (num > mCards.size()) {
            System.err.println("Can't peek more than the size of the column.");
            return subColumn;
        }

        for (int i = 0; i < num; ++i) {
            Card card = peek(i);
            if (!card.isFaceUp()) {
                System.err.println("Can only peek cards that are face up.");
                return subColumn;
            }
        }

        List<Card> temp = new ArrayList<Card>();
        for (int i = 0; i < num; ++i) {
            Card card = peek(i);
            temp.add(card);
        }

        for (int i = temp.size() - 1; i >= 0; --i) {
            subColumn.push(temp.get(i));
        }

        return subColumn;

    }

    public CardColumn removeSubColumn(int num) {

        CardColumn subColumn = new CardColumn();

        if (num > mCards.size()) {
            System.err.println("Can't remove more than the size of the column.");
            return subColumn;
        }

        for (int i = 0; i < num; ++i) {
            Card card = peek(i);
            if (!card.isFaceUp()) {
                System.err.println("Can only remove cards that are face up.");
                return subColumn;
            }
        }

        List<Card> temp = new ArrayList<Card>();
        for (int i = 0; i < num; ++i) {
            Card card = pop();
            temp.add(card);
        }

        for (int i = temp.size() - 1; i >= 0; --i) {
            subColumn.push(temp.get(i));
        }

        return subColumn;
    }

    public void turnTopCardUp() {
        Card card = peek();
        if (card != null) {
            card.setFaceUp(true);
        }
    }

    public boolean canAdd(Card card) {
        if (card == null) {
            return false;
        } else {
            return compatible(card);
        }
    }

    public boolean canAdd(CardColumn column) {

        if (column.empty()) {
            return true;
        }

        Card lastInSubColumn = column.peekLast();
        if (compatible(lastInSubColumn)) {
            return true;
        }

        return false;
    }

    private boolean compatible(Card append) {

        // If the column is empty, we only allow adding a King
        if (empty()) {
            if (append.getValue() == Value.King) {
                return true;
            } else {
                return false;
            }
        }

        // If the column isn't empty, check the card we're adding is
        // compatible with the current top card
        Card topCard = peek();

        // Can't add a card if the top card isn't face up.
        if (!topCard.isFaceUp()) {
            return false;
        }

        // Cards must be of alternate suits
        Suit firstSuit = topCard.getSuit();
        Suit secondSuit = append.getSuit();
        if (firstSuit.isBlack() == secondSuit.isBlack()) {
            return false;
        }

        // Cards must follow the specified Value order
        int firstValueIndex = REQUIRED_ORDER.indexOf(topCard.getValue());
        int secondValueIndex = REQUIRED_ORDER.indexOf(append.getValue());
        if (firstValueIndex != secondValueIndex - 1) {
            return false;
        }

        // The conditions have been met
        return true;
    }
}

