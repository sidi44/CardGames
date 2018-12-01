package com.sidi.cardgames.patience.model;

import com.sidi.cardgames.card.Card;
import com.sidi.cardgames.card.CardColumn;
import com.sidi.cardgames.card.Deck;
import com.sidi.cardgames.card.FoundationPile;
import com.sidi.cardgames.card.Suit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 29/12/2017.
 */
public class PatienceGameState {

    private Deck mDeck;
    private List<FoundationPile> mFoundationPiles;
    private List<CardColumn> mCardColumns;
    private List<Card> mSideDeck;
    private boolean mGameQuit;

    private static final int NUM_COLUMNS = 7;
    private static final int ADVANCE_DECK_NUM = 3;

    public PatienceGameState() {

        // Create a new deck of cards
        mDeck = new Deck();

        // Initialise the foundation piles
        mFoundationPiles = new ArrayList<FoundationPile>();
        for (Suit suit : Suit.values()) {
            mFoundationPiles.add(new FoundationPile(suit));
        }

        // Create all the card columns
        mCardColumns = new ArrayList<CardColumn>();
        for (int i = 0; i < NUM_COLUMNS; ++i) {
            mCardColumns.add(new CardColumn());
        }

        // Deal the cards into the card columns
        for (int i = 0; i < NUM_COLUMNS; ++i) {
            for (int j = i; j < NUM_COLUMNS; ++j) {
                CardColumn column = mCardColumns.get(j);
                Card card = mDeck.deal();
                column.dealCard(card);
            }
        }

        // Turn over the last card of each column
        for (int i = 0; i < NUM_COLUMNS; ++i) {
            CardColumn column = mCardColumns.get(i);
            column.turnTopCardUp();
        }

        // Initialise the side deck, empty to start with
        mSideDeck = new ArrayList<Card>();

        // We haven't quit the game, yet!
        mGameQuit = false;
    }

    public Deck getDeck() {
        return mDeck;
    }

    public List<FoundationPile> getFoundationPiles() {
        return mFoundationPiles;
    }

    public List<CardColumn> getCardColumns() {
        return mCardColumns;
    }

    public List<Card> getSideDeck() {
        return mSideDeck;
    }

    public boolean getGameQuit() {
        return mGameQuit;
    }

    public boolean gameWon() {

        for (FoundationPile pile : mFoundationPiles) {
            if (!pile.complete()) {
                return false;
            }
        }

        return true;
    }

    public void advanceDeck() {

        // Put the cards in the side deck back into the deck
        for (Card card : mSideDeck) {
            card.setFaceUp(false);
            mDeck.insertCardEnd(card);
        }
        mSideDeck.clear();

        // Deal new cards into the side deck
        int deckSize = mDeck.size();
        for (int i = 0; i < ADVANCE_DECK_NUM && i < deckSize; ++i) {
            mSideDeck.add(mDeck.deal());
        }

        // Turn the top card over so it's face up
        Card topCard = mSideDeck.get(mSideDeck.size() - 1);
        topCard.setFaceUp(true);
    }

    public boolean moveColumnToColumn(int source, int target, int numCards) {

        // Get the two columns of interest
        CardColumn sourceCol = mCardColumns.get(source);
        CardColumn targetCol = mCardColumns.get(target);

        // Get the sub column of cards. This will return an empty sub-column
        // if the input is bogus.
        CardColumn subCol = sourceCol.peekSubColumn(numCards);
        if (subCol.empty()) {
            return false;
        }

        if (targetCol.canAdd(subCol)) {
            CardColumn toMove = sourceCol.removeSubColumn(numCards);
            targetCol.appendColumn(toMove);
            sourceCol.turnTopCardUp();
            return true;
        } else {
            return false;
        }

    }

    public boolean moveColumnToFoundationPile(int source, int target) {

        CardColumn sourceCol = mCardColumns.get(source);
        FoundationPile targetPile = mFoundationPiles.get(target);

        if (sourceCol.empty()) {
            return false;
        }

        Card card = sourceCol.peek();
        if (targetPile.canAdd(card)) {
            Card toMove = sourceCol.pop();
            targetPile.addCard(toMove);
            sourceCol.turnTopCardUp();
            return true;
        } else {
            return false;
        }

    }

    public boolean moveSideDeckToColumn(int target) {

        CardColumn targetCol = mCardColumns.get(target);

        int sourceIndex = mSideDeck.size() - 1;
        Card card = mSideDeck.remove(sourceIndex);

        if (targetCol.appendCard(card)) {
            if (!mSideDeck.isEmpty()) {
                Card newTop = mSideDeck.get(mSideDeck.size() - 1);
                newTop.setFaceUp(true);
            }
            return true;
        } else {
            mSideDeck.add(card);
            return false;
        }

    }

    public boolean moveSideDeckToFoundationPile(int target) {

        FoundationPile targetPile = mFoundationPiles.get(target);

        int sourceIndex = mSideDeck.size() - 1;
        Card card = mSideDeck.remove(sourceIndex);

        if (targetPile.addCard(card)) {
            if (!mSideDeck.isEmpty()) {
                Card newTop = mSideDeck.get(mSideDeck.size() - 1);
                newTop.setFaceUp(true);
            }
            return true;
        } else {
            mSideDeck.add(card);
            return false;
        }

    }

    public void quitGame() {
        mGameQuit = true;
    }

}
