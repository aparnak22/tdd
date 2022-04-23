package com.techreturners.poker;

import java.util.Scanner;

public class Main {

    public static void main(String... args){
        boolean tryAgain = true;
        Scanner consoleInput = new Scanner(System.in);

        while (tryAgain) {
            System.out.println("Player 1 ");
            String player1 = consoleInput.nextLine();

            System.out.println("Player 2 ");
            String player2 = consoleInput.nextLine();

            GamePlay game = new GamePlay(player1, player2);
            if (game.winnerPlayerNo() == 0 ){
                System.out.println("Tie");
            }
            else System.out.println("Player no " + game.winnerPlayerNo() + "  wins. - With " +
                    game.winningHand().getPattern().getDescription());

            System.out.println("Play again (Y/N) ? ");
            String continuePlay = consoleInput.nextLine();
            tryAgain = continuePlay.equalsIgnoreCase("Y");
        }

    }
}
