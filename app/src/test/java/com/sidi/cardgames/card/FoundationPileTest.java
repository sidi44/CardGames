package com.sidi.cardgames.card;

import org.junit.Test;

import static org.junit.Assert.*;

public class FoundationPileTest {

    @Test
    public void getSuit() {

        for (Suit suit : Suit.values()) {
            FoundationPile pile = new FoundationPile(suit);
            String msg = "Check suit is " + suit.getString();
            assertEquals(msg, suit, pile.getSuit());
        }

    }

    @Test
    public void getTopCard() {

        Suit suit = Suit.Spade;
        FoundationPile pile = new FoundationPile(suit);
        assertNull("Check empty pile returns null top card", pile.getTopCard());

        Card ace = new Card(suit, Value.Ace);
        pile.addCard(ace);
        assertEquals("Check top card is last added card", ace, pile.getTopCard());

        Card two = new Card(suit, Value.Two);
        pile.addCard(two);
        assertEquals("Check top card is last added card", two, pile.getTopCard());

        Card heart = new Card(Suit.Heart, Value.Three);
        pile.addCard(heart);
        assertEquals("Check top card after failed add card", two, pile.getTopCard());

    }

    @Test
    public void testCardAdding() {

        Suit suit = Suit.Diamond;
        FoundationPile pile = new FoundationPile(suit);

        Card club = new Card(Suit.Club, Value.Ace);
        Card two = new Card(suit, Value.Two);

        // Loop through all values and check we can only add cards of the correct suit in the right
        // sequence
        for (Value value : Value.values()) {

            assertFalse("Check can't add card of wrong suit", pile.canAdd(club));
            assertFalse("Check card of wrong suit not added", pile.addCard(club));

            if (value != Value.Two) {
                assertFalse("Check can't add card with wrong value", pile.canAdd(two));
                assertFalse("Check card with wrong value not added", pile.addCard(two));
            }

            Card card = new Card(suit, value);
            assertTrue("Check can add card in correct sequence", pile.canAdd(card));
            assertTrue("Check card added in correct sequence", pile.addCard(card));
        }
    }

    @Test
    public void empty() {

        Suit suit = Suit.Club;
        FoundationPile pile = new FoundationPile(suit);

        assertTrue("Expect pile to start empty", pile.empty());

        pile.addCard(new Card(suit, Value.Ace));
        assertFalse("Check pile not empty after card added", pile.empty());
    }

    @Test
    public void complete() {

        Suit suit = Suit.Heart;
        FoundationPile pile = new FoundationPile(suit);

        for (Value value : Value.values()) {
            assertFalse("Check pile not complete until King added", pile.complete());
            pile.addCard(new Card(suit, value));
        }

        assertTrue("Check pile complete after King added", pile.complete());
    }

}