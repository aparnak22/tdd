package com.techreturners.poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHandPattern {

    @Test
    public void testHandPatternFourOfAKind(){
        Hand playerHand = new Hand("5H 5D 5C 5S 6H");

        assertEquals(5,playerHand.getCards().size());
        assertEquals(Pattern.FOUR_OF_A_KIND, playerHand.getPattern());
        assertEquals(5, playerHand.getValue());

/*
        Hand playerHand2 = new Hand("7H 3H 4H 5H 6H");

        assertEquals(5,playerHand2.getCards().size());
        assertEquals(Pattern.STRAIGHT_FLUSH, playerHand2.getPattern());
        assertEquals(7, playerHand2.getValue());

        Hand playerHand3 = new Hand("8H TH 9H QH JH");

        assertEquals(5,playerHand3.getCards().size());
        assertEquals(Pattern.STRAIGHT_FLUSH, playerHand3.getPattern());
        assertEquals(12, playerHand3.getValue());*/
    }

    @Test
    public void testHandPatternFullHouse() {
        Hand playerHand = new Hand("5H 5D 5C 6S 6H");

        assertEquals(5, playerHand.getCards().size());
        assertEquals(Pattern.FULL_HOUSE, playerHand.getPattern());
        assertEquals(5, playerHand.getValue());
    }
}
