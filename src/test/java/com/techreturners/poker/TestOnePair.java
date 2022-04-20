package com.techreturners.poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOnePair {

    @Test
    public void testOnePairValue(){
        String player1 = "9H QC 5S 9C KD";
        //String player2 = "2C 3H 4S 8C AH";

        Hand hand1 = new Hand(player1);

        //GamePlay game = new GamePlay(player1, player2);
        assertEquals(Pattern.ONE_PAIR, hand1.getPattern());
        assertEquals(9,hand1.getValue());
        assertEquals(13,hand1.getNextValue(2));
        assertEquals(12,hand1.getNextValue(3));
        assertEquals(5 ,hand1.getNextValue(4));
    }
}
