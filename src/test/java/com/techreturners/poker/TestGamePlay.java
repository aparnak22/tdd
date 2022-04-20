package com.techreturners.poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGamePlay {

    @Test
    public void testOnePlayerWinsWithStraightFlush(){
        String player1 = "2C 2H 2S 3C 3H";
        String player2 = "TC AC QC KC JC";
        GamePlay game = new GamePlay(player1, player2);
        assertEquals(2,game.winnerPlayerNo());
        assertEquals("Straight flush", game.winningHand().getPattern().getDescription());
        //game.winnerdetails();


    }

    @Test
    public void testOnePlayerWinsWithHighCard(){
        String player1 = "2H 3D 5S 9C KD";
        String player2 = "2C 3H 4S 8C AH";

        GamePlay game = new GamePlay(player1, player2);

        assertEquals(2, game.winnerPlayerNo());
        assertEquals(14,game.winningHand().getValue());

    }
}

