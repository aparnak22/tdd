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
    public void testGameOverWhenThreeInRowMatch()  {
        TicTacToeKata game = new TicTacToeKata();
        game.markSquare(2,2);//  X
        game.markSquare(1,1);//0__,_X_,___
        game.markSquare(2,1);//0__,XX_,___
        game.markSquare(1,2);//00_,XX_,___
        int moveResult = game.markSquare(2,3);//00_,XXX,___
        assertEquals(0,moveResult);
    }

    @Test
    public void testWinnerInRow()  {
        TicTacToeKata game = new TicTacToeKata();
        game.markSquare(2,2);//  X
        game.markSquare(1,1);//0__,_X_,___
        game.markSquare(2,1);//0__,XX_,___
        game.markSquare(1,2);//00_,XX_,___
        int moveResult = game.markSquare(2,3);//00_,XXX,___
        int winner = game.getWinner();

        assertEquals(0,moveResult);
        assertEquals(1,winner);

        TicTacToeKata game2 = new TicTacToeKata();
        game2.markSquare(2,2);//  X
        game2.markSquare(1,1);//0__,_X_,___
        game2.markSquare(2,1);//0__,XX_,___
        game2.markSquare(1,2);//00_,XX_,___
        game2.markSquare(3,1);//00_,XX_,X__
        int moveResult2 = game2.markSquare(1,3);//000,XX_,X__
        assertEquals(0, moveResult2);
        assertEquals(2,game2.getWinner());
    }


    @Test
    public void testGameOverWhenThreeInColMatch()  {
        TicTacToeKata game = new TicTacToeKata();
        game.markSquare(2,2);//  X
        game.markSquare(1,1);//0__,_X_,___
        game.markSquare(1,2);//0X_,_X_,___
        game.markSquare(2,1);//0X_,OX_,___
        int moveResult = game.markSquare(3,2);//0X_,OX_,_X_
        assertEquals(0,moveResult);
    }

    @Test
    public void testWinnerInCol() {
        TicTacToeKata game = new TicTacToeKata();
        game.markSquare(2,2);//  X
        game.markSquare(1,1);//0__,_X_,___
        game.markSquare(1,2);//0X_,_X_,___
        game.markSquare(2,1);//0X_,OX_,___

        int moveResult = game.markSquare(3,2);//0X_,OX_,_X_

        assertEquals(0,moveResult);
        assertEquals(1,  game.getWinner());
    }

    @Test
    public void testWinnerInDiagonal() {
        TicTacToeKata game = new TicTacToeKata();
        game.markSquare(2,2);//  X
        game.markSquare(1,1);//0__,_X_,___
        game.markSquare(1,3);//0_X,_X_,___
        game.markSquare(2,1);//0_X,OX_,___

        int moveResult = game.markSquare(3,1);//0_X,OX_,XX_

        assertEquals(0,moveResult);
        assertEquals(1,  game.getWinner());
    }
}
