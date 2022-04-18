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

}
