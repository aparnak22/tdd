package com.techreturners.poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHighestCard {

    @Test
    public void testHighestCardValue(){
        String player1 = "2H 3D 5S 9C KD";
        String player2 = "2C 3H 4S 8C AH";

        Hand hand1 = new Hand(player1);
        Hand hand2 = new Hand(player2);

        //GamePlay game = new GamePlay(player1, player2);
        assertEquals(Pattern.HIGHEST_CARD, hand1.getPattern());
        assertEquals(13,hand1.getValue());

        assertEquals(Pattern.HIGHEST_CARD, hand2.getPattern());
        assertEquals(14,hand2.getValue());
    }
}
