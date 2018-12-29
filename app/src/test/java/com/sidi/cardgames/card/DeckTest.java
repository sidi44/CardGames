package com.sidi.cardgames.card;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void testInsertAndDeal() {

        Deck deck = new Deck();
        emptyDeck(deck);

        assertNull("Check dealing a card from an empty deck returns null", deck.deal());

        Card card1 = new Card(Suit.Spade, Value.Ace);
        Card card2 = new Card(Suit.Heart, Value.Queen);
        Card card3 = new Card(Suit.Club, Value.Jack);

        deck.insertCardEnd(card1);
        deck.insertCardEnd(card2);
        deck.insertCardEnd(card3);

        assertEquals("Check first card dealt first", card1, deck.deal());
        assertEquals("Check second card dealt second", card2, deck.deal());
        assertEquals("Check third card dealt third", card3, deck.deal());

        assertNull("Check dealing a card from an empty deck returns null", deck.deal());
    }

    @Test
    public void size() {

        Deck deck = new Deck();
        assertEquals("A new deck should have 52 cards", 52, deck.size());

        emptyDeck(deck);
        assertEquals("An empty deck should have 0 cards", 0, deck.size());

        Card card1 = new Card(Suit.Spade, Value.Ace);
        Card card2 = new Card(Suit.Heart, Value.Queen);
        Card card3 = new Card(Suit.Club, Value.Jack);

        deck.insertCardEnd(card1);
        assertEquals("Check deck has one card", 1, deck.size());

        deck.insertCardEnd(card2);
        assertEquals("Check deck has two cards", 2, deck.size());

        deck.insertCardEnd(card3);
        assertEquals("Check deck has three cards", 3, deck.size());

    }

    @Test
    public void isEmpty() {

        Deck deck = new Deck();
        assertFalse("A new deck should not be empty", deck.isEmpty());

        emptyDeck(deck);
        assertTrue("Check an empty deck is empty", deck.isEmpty());

        Card card1 = new Card(Suit.Spade, Value.Ace);

        deck.insertCardEnd(card1);
        assertFalse("Check deck with one card added is not empty", deck.isEmpty());

        deck.deal();
        assertTrue("Check deck is empty after dealing last card", deck.isEmpty());

    }

    /**
     * Empty the provided deck.
     *
     * Most tests here want to start with an empty Deck, so we use this convenience function to
     * create one.
     *
     * @param deck - the Deck to be emptied.
     */
    private void emptyDeck(Deck deck) {

        while (!deck.isEmpty()) {
            deck.deal();
        }

    }
}