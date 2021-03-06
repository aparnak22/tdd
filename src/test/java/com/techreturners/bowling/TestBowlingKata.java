package com.techreturners.bowling;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBowlingKata {

    @Test
    public void testCalcScoreForPartialPinsKnockedDown(){
        char[][] framesArr = new char[][]{ {'9','-'},
                {'9','-'},{'9','-'},{'9','-'},{'9','-'},
                {'9','-'},{'9','-'},{'9','-'},{'9','-'},{'9','-'}};
        BowlingKata bk = new  BowlingKata();

        int score = bk.calculateScore(Arrays.asList(framesArr));

        assertEquals(90,score);

        char[][] framesArr2 = new char[][]{ {'8','-'},
                {'9','-'},{'9','-'},{'7','-'},{'9','-'},
                {'9','-'},{'9','-'},{'9','-'},{'9','-'},{'9','-'}};

        assertEquals(87,bk.calculateScore(Arrays.asList(framesArr2)));
    }

    @Test
    public void testCalcScoreForOneSpareBeforeLastTurn(){
        char[][] framesArr = new char[][]{ {'9','/'},
                {'9','-'},{'9','-'},{'9','-'},{'9','-'},
                {'9','-'},{'9','-'},{'9','-'},{'9','-'},{'9','-'}};
        BowlingKata bk = new  BowlingKata();
        int score = bk.calculateScore(Arrays.asList(framesArr));
         assertEquals(100,score);
    }

    @Test
    public void testCalcScoreForSpareAtLastTurn(){
        char[][] framesArr = new char[][]{ {'9','-'},
                {'9','-'},{'9','-'},{'9','-'},{'9','-'},
                {'9','-'},{'9','-'},{'9','-'},{'9','-'},{'9','/'},{'9'}};
        BowlingKata bk = new  BowlingKata();
        int score = bk.calculateScore(Arrays.asList(framesArr));
        assertEquals(100,score);
    }

    @Test
    public void testCalcScoreForSpareAtEveryTurnExceptTheBonusThrow(){
        char[][] framesArr = new char[][]{ {'5','/'},
                {'5','/'},{'5','/'},{'5','/'},{'5','/'},
                {'5','/'},{'5','/'},{'5','/'},{'5','/'},{'5','/'},{'5'}};
        BowlingKata bk = new  BowlingKata();
        int score = bk.calculateScore(Arrays.asList(framesArr));
        assertEquals(150,score);
    }

    @Test
    public void testCalcScoreForStrikeBeforeLastTurn(){
        char[][] framesArr = new char[][]{ {'X'},
                {'9','-'},{'9','-'},{'9','-'},{'9','-'},
                {'9','-'},{'9','-'},{'9','-'},{'9','-'},{'9','-'}};
        BowlingKata bk = new  BowlingKata();
        int score = bk.calculateScore(Arrays.asList(framesArr));
        assertEquals(100,score);
    }


    @Test
    public void testCalcScoreForStrikeAtLastTurn(){
        char[][] framesArr = new char[][]{
                {'9','-'},{'9','-'},{'9','-'},{'9','-'},
                {'9','-'},{'9','-'},{'9','-'},{'9','-'},{'9','-'},{'X','3','5'}};
        BowlingKata bk = new  BowlingKata();
        int score = bk.calculateScore(Arrays.asList(framesArr));
        assertEquals(99,score);
    }

    @Test
    public void testCalcScoreForStrikeAtLastTurnLastThrows(){
        char[][] framesArr = new char[][]{
                {'9','-'},{'9','-'},{'9','-'},{'9','-'},
                {'9','-'},{'9','-'},{'9','-'},{'9','-'},{'9','-'},{'X','X','X'}};
        BowlingKata bk = new  BowlingKata();
        int score = bk.calculateScore(Arrays.asList(framesArr));
        assertEquals(111,score);
    }

    @Test
    public void testCalcScoreForPassingOneThrowAtATime(){
        char[][] framesArr = new char[][]{ {'9','-'},
                {'9','-'},{'9','-'},{'9','-'},{'9','-'},
                {'9','-'},{'9','-'},{'9','-'},{'9','-'},{'9','-'}};
        BowlingKata bk = new  BowlingKata();
        for (char[] frames:framesArr
             ) {
            bk.addFrame(frames);
       }

        int score = bk.calculateScore();

        assertEquals(90,score);

        char[][] framesArr2 = new char[][]{ {'8','-'},
                {'9','-'},{'9','-'},{'7','-'},{'9','-'},
                {'9','-'},{'9','-'},{'9','-'},{'9','-'},{'9','-'}};

        BowlingKata bk2 = new  BowlingKata();
        for (char[] frames:framesArr2
        ) {
            bk2.addFrame(frames);
        }

        assertEquals(87,bk2.calculateScore());
    }

    @Test
    public void testPerfectGame(){
        BowlingKata bk2 = new  BowlingKata();
        assertEquals(300, bk2.calculateScore("X X X X X X X X X XXX"));
    }
}


