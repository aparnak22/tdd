package com.techreturners.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTicTacToeKata {

    @Test
    public void testPlayerXMove(){
        TicTacToeKata game = new TicTacToeKata();
        int moveResult = game.markSquare(2,2);
        assertEquals(1,moveResult);
    }

    @Test
    public void testPlayerOMove(){
        TicTacToeKata game = new TicTacToeKata();
        game.markSquare(2,2);
        int moveResult = game.markSquare(1,1);
        assertEquals(1,moveResult);
    }

    @Test
    public void testGameOver()  {
        TicTacToeKata game = new TicTacToeKata();
        game.markSquare(2,2);//  X
        game.markSquare(1,1);//0__,_X_,___
        game.markSquare(2,1);//0__,XX_,___
        game.markSquare(1,2);//00_,XX_,___
        int moveResult = game.markSquare(2,3);//00_,XXX,___
        assertEquals(0,moveResult);
    }

    @Test
    public void testWinner()  {
        TicTacToeKata game = new TicTacToeKata();
        game.markSquare(2,2);//  X
        game.markSquare(1,1);//0__,_X_,___
        game.markSquare(2,1);//0__,XX_,___
        game.markSquare(1,2);//00_,XX_,___
        int moveResult = game.markSquare(2,3);//00_,XXX,___
        int winner = game.getWinner();
        assertEquals(1,winner);
    }
}
