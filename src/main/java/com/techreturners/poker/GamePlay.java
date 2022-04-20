package com.techreturners.poker;

public class GamePlay {
    private final Hand player1Hand ;
    private final Hand player2Hand ;
    private Hand winningHand ;
    private int winnerPlayerNo;

    public GamePlay(String player1, String player2) {
        player1Hand = new Hand(player1);
        player2Hand  = new Hand(player2);
        setWinner();
    }


    private void setWinner() {
        if (player1Hand.getPattern().getPostion()  < player2Hand.getPattern().getPostion()){
            winningHand = player1Hand;
            winnerPlayerNo = 1;
        }
        else if(player1Hand.getPattern().getPostion()  > player2Hand.getPattern().getPostion()){
            winningHand = player2Hand;
            winnerPlayerNo = 2;
        }
        else if(player1Hand.getPattern().getPostion()  == player2Hand.getPattern().getPostion()){
            int p1Value = player1Hand.getValue();
            int p2Value = player2Hand.getValue(); int rank = 1;

            while (rank < 5 && p1Value == p2Value){
                p1Value = player1Hand.getNextValue(rank);
                p2Value = player1Hand.getNextValue(rank);
                rank++;
            }
            if (p1Value > p2Value){
                winningHand = player1Hand;
                winnerPlayerNo = 1;
            }
            else if (p1Value < p2Value){
                winningHand = player2Hand;
                winnerPlayerNo = 2;
            }
            else {
                winnerPlayerNo = 0;//tie
            }
        }
        //return 0;
    }

    public  Hand winningHand(){
        return winningHand;
    }

    public int winnerPlayerNo() {
        return winnerPlayerNo;
    }
}
