package com.techreturners.poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestThreeOfAKind {

    @Test
    public void testThreeOfAKindValue(){
        String player1 = "9H 9D 5S 9C KD";
        String player2 = "2C 3H 4S 8C AH";

        Hand hand1 = new Hand(player1);
        Hand hand2 = new Hand(player2);

        //GamePlay game = new GamePlay(player1, player2);
        assertEquals(Pattern.THREE_OF_A_KIND, hand1.getPattern());
       // assertEquals(9,hand1.getValue());

        assertEquals(Pattern.HIGH_CARD, hand2.getPattern());
       // assertEquals(14,hand2.getValue());
    }
}
