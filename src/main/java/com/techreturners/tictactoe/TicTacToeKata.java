package com.techreturners.tictactoe;

public class TicTacToeKata {
    int turn = 1; //1 is X and 0 is 2
    int[][] gameBoard = new int[3][3];

    public int markSquare(int row , int col) {
        gameBoard[row-1][col-1] = turn;
        turn = (turn == 1) ? 2 : 1;
        if (checkIfGameContinues())
            return 1;
        else
            return 0;
    }

    private boolean checkIfGameContinues(){
        for (int[] row : gameBoard) {
            //if all cols in a row match then we have a winner, end game
            if ( row[0] == row[1] && row[1] == row[2] && (row[1] == 2 || row[1]==1) ){
                return false;
            }
        }
        return true;
    }
}
