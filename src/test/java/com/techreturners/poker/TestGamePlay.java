package com.techreturners.poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
      //  assertEquals(14,game.winningHand().getValue());

    }
    /*Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH
Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S
Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C KH
Black: 2H 3D 5S 9C KD  White: 2D 3H 5C 9S KH
    * */
    @Test
    public void testWithFullHouse(){
        String player1 = "2H 4S 4C 2D 4H";
        String player2 = "2S 8S AS QS 3S";

        GamePlay game = new GamePlay(player1, player2);

        assertEquals(1, game.winnerPlayerNo());
        assertEquals(Pattern.FULL_HOUSE, game.winningHand().getPattern());
       // assertEquals(4,game.winningHand().getValue());
    }

    @Test
    public void testWithHighCard(){
        String player1 = "2H 3D 5S 9C KD";
        String player2 = "2C 3H 4S 8C KH";

        GamePlay game = new GamePlay(player1, player2);

        assertEquals(1, game.winnerPlayerNo());
        assertEquals(Pattern.HIGH_CARD, game.winningHand().getPattern());
       // assertEquals(9,game.winningHand().getValue());
    }


    @Test
    public void testTie(){
        String player1 = "2H 3D 5S 9C KD";
        String player2 = "2D 3H 5C 9S KH";

        GamePlay game = new GamePlay(player1, player2);

        assertEquals(0, game.winnerPlayerNo());
        assertNull(game.winningHand());

    }


    @Test
    public void testPlayer1WinsWithStraight(){
        String player1 = "2S 3H 4H 5S 6C";
        String player2 = "AH AC 5H 6H AS";
        GamePlay game = new GamePlay(player1, player2);
        assertEquals(1,game.winnerPlayerNo());
        assertEquals("Straight", game.winningHand().getPattern().getDescription());

    }
}

