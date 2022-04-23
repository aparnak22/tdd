package com.techreturners.poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHand {

    @Test
    public void testCreateHand(){
        //Hand playerHand = new Hand("2H 3D 5S 9C KD");
        Hand playerHand = new Hand("2H 3D 5S 9C 4D");

        assertEquals(5,playerHand.getCards().size());

    }

    @Test
    public void testHandPatternStraightFlush(){
        Hand playerHand = new Hand("2H 3H 4H 5H 6H");

        assertEquals(5,playerHand.getCards().size());
        assertEquals(Pattern.STRAIGHT_FLUSH, playerHand.getPattern());
      //  assertEquals(6, playerHand.getValue());


        Hand playerHand2 = new Hand("7H 3H 4H 5H 6H");

        assertEquals(5,playerHand2.getCards().size());
        assertEquals(Pattern.STRAIGHT_FLUSH, playerHand2.getPattern());
        //assertEquals(7, playerHand2.getValue());

        Hand playerHand3 = new Hand("8H TH 9H QH JH");

        assertEquals(5,playerHand3.getCards().size());
        assertEquals(Pattern.STRAIGHT_FLUSH, playerHand3.getPattern());
       // assertEquals(12, playerHand3.getValue());
    }
}
