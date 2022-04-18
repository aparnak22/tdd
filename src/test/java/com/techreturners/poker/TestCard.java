package com.techreturners.poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCard {

    @Test
    public void testCardValue(){
        Card twos = new Card("2H");
        assertEquals(Suit.H , twos.getSuit());
        assertEquals(2, twos.getValue());
    }
}
