package com.techreturners.poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCard {

    @Test
    public void testNumberCardValue(){
        Card twos = new Card("2H");
        assertEquals(Suit.H , twos.getSuit());
        assertEquals(2, twos.getValue());

        Card threes = new Card("3D");
        assertEquals(Suit.D , threes.getSuit());
        assertEquals(3, threes.getValue());

        Card fours = new Card("4S");
        assertEquals(Suit.S , fours.getSuit());
        assertEquals(4, fours.getValue());

        Card fives = new Card("5C");
        assertEquals(Suit.C , fives.getSuit());
        assertEquals(5, fives.getValue());
    }

    @Test
    public void testFaceCardValue(){
        Card card1 = new Card("AH");
        assertEquals(Suit.H , card1.getSuit());
        assertEquals(14, card1.getValue());

        Card card2 = new Card("JS");
        assertEquals(Suit.S , card2.getSuit());
        assertEquals(11, card2.getValue());

        Card card3 = new Card("QC");
        assertEquals(Suit.C , card3.getSuit());
        assertEquals(12, card3.getValue());

        Card card4 = new Card("KD");
        assertEquals(Suit.D , card4.getSuit());
        assertEquals(13, card4.getValue());
    }
}
