package com.techreturners.tictactoe;

public class TicTacToeKata {
    int turn = 1; //1 is X and 0 is 2
    int[][] gameBoard = new int[3][3];
    int winner = 0;

    public int markSquare(int row , int col) {
        gameBoard[row-1][col-1] = turn;
        turn = (turn == 1) ? 2 : 1;
        if (checkIfGameContinues())
            return 1;
        else
            return 0;
    }

    private boolean checkIfGameContinues(){
        return !checkThreeInARowMatch() && !checkThreeInAColMatch() &&!checkThreeInADiagonalMatch();
    }

    private boolean checkThreeInAColMatch() {
        for(int col = 0 ; col<3; col++) {
            if (gameBoard[0][col] == gameBoard[1][col] && gameBoard[1][col] == gameBoard[2][col]
                    && (gameBoard[0][col] == 2 || gameBoard[0][col]==1) ){
                winner = gameBoard[0][col];
                return true;
            }
        }
        return false;
    }

    private boolean checkThreeInARowMatch() {
        for (int[] row : gameBoard) {
            //if all cols in a row match then we have a winner, end game
            if ( row[0] == row[1] && row[1] == row[2] && (row[1] == 2 || row[1]==1) ){
                winner = row[0];
                return true;
            }
        }
        return false;
    }

    private boolean checkThreeInADiagonalMatch() {
            if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]
                    && (gameBoard[0][0] == 2 || gameBoard[0][0]==1) ){
                winner = gameBoard[0][0];
                return true;
            }
            if (gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0]
                    && (gameBoard[0][2] == 2 || gameBoard[0][2]==1) ){
                winner = gameBoard[0][2];
                return true;
            }

        return false;
    }

    public int getWinner() {
        return winner;
    }
}
