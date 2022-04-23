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
        int result = player1Hand.compareWith(player2Hand);
        if (result > 0 ){
            winnerPlayerNo = 1;
            winningHand = player1Hand;
        }
        else if ( result < 0 ){
            winnerPlayerNo = 2;
            winningHand = player2Hand;
        }
        else winnerPlayerNo = 0;

    }

    public  Hand winningHand(){
        return winningHand;
    }

    public int winnerPlayerNo() {
        return winnerPlayerNo;
    }


}
