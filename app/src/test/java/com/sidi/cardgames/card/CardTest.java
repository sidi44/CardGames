package com.sidi.cardgames.card;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void getSuit() {

        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                Card card = new Card(suit, value);
                String msg = "Check suit " + suit.getString() + " with value " + value.getString();
                assertEquals(msg, suit, card.getSuit());
            }
        }

    }

    @Test
    public void getValue() {

        for (Value value: Value.values()) {
            for (Suit suit : Suit.values()) {
                Card card = new Card(suit, value);
                String msg = "Check value " + value.getString() + " with suit " + suit.getString();
                assertEquals(msg, value, card.getValue());
            }
        }

    }

    @Test
    public void testFaceUp() {

        Card card = new Card(Suit.Spade, Value.Ace);
        assertFalse("Expect cards to be face down by default", card.isFaceUp());

        card.setFaceUp(true);
        assertTrue("Card should now be face up", card.isFaceUp());

        card.setFaceUp(false);
        assertFalse("Card should now be face down", card.isFaceUp());
    }

    @Test
    public void testToString() {

        // Test face down / face up card
        {
            Card card = new Card(Suit.Spade, Value.Ace);
            assertEquals("Test face down card", "???", card.toString());
            card.setFaceUp(true);
            assertEquals("Test face up card", " SA", card.toString());
            card.setFaceUp(false);
            assertEquals("Test face down card again", "???", card.toString());
        }

        // Test a card of each value, alternating suits

        {
            Card card = new Card(Suit.Spade, Value.Ace);
            card.setFaceUp(true);
            assertEquals("Test ace of spades", " SA", card.toString());
        }

        {
            Card card = new Card(Suit.Heart, Value.Two);
            card.setFaceUp(true);
            assertEquals("Test two of hearts", " H2", card.toString());
        }

        {
            Card card = new Card(Suit.Club, Value.Three);
            card.setFaceUp(true);
            assertEquals("Test three of clubs", " C3", card.toString());
        }

        {
            Card card = new Card(Suit.Diamond, Value.Four);
            card.setFaceUp(true);
            assertEquals("Test four of diamonds", " D4", card.toString());
        }

        {
            Card card = new Card(Suit.Spade, Value.Five);
            card.setFaceUp(true);
            assertEquals("Test five of spades", " S5", card.toString());
        }

        {
            Card card = new Card(Suit.Heart, Value.Six);
            card.setFaceUp(true);
            assertEquals("Test six of hearts", " H6", card.toString());
        }

        {
            Card card = new Card(Suit.Club, Value.Seven);
            card.setFaceUp(true);
            assertEquals("Test seven of clubs", " C7", card.toString());
        }

        {
            Card card = new Card(Suit.Diamond, Value.Eight);
            card.setFaceUp(true);
            assertEquals("Test eight of diamonds", " D8", card.toString());
        }

        {
            Card card = new Card(Suit.Spade, Value.Nine);
            card.setFaceUp(true);
            assertEquals("Test nine of spades", " S9", card.toString());
        }

        {
            Card card = new Card(Suit.Heart, Value.Ten);
            card.setFaceUp(true);
            assertEquals("Test ten of hearts", "H10", card.toString());
        }

        {
            Card card = new Card(Suit.Club, Value.Jack);
            card.setFaceUp(true);
            assertEquals("Test jack of clubs", " CJ", card.toString());
        }

        {
            Card card = new Card(Suit.Diamond, Value.Queen);
            card.setFaceUp(true);
            assertEquals("Test queen of diamonds", " DQ", card.toString());
        }

        {
            Card card = new Card(Suit.Spade, Value.King);
            card.setFaceUp(true);
            assertEquals("Test king of spades", " SK", card.toString());
        }

    }

}