package com.techreturners.poker;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards = new ArrayList<>();
    private  Pattern pattern;
    private int handValue ;

    public Hand(String cardsInHand) {
        String[] cardsArr = cardsInHand.split(" ");
        for (String cardStr : cardsArr
             ) {
            cards.add(new Card(cardStr));
        }
        setPattern();
    }

    private void setPattern() {
        setStraightFlush();
    }


    public List<Card> getCards() {
        return cards;
    }

    private boolean setStraightFlush() {
        boolean sameSuit = false;
        for (int i = 0; i < 1; i++) {
            if ( cards.get(i) .suit() == cards.get(i+1).suit() &&
                    cards.get(i).suit() == cards.get(i+2).suit() &&
                        cards.get(i).suit() == cards.get(i+3).suit() &&
                            cards.get(i).suit() == cards.get(i+4).suit()){
                sameSuit = true;
            }

        }
        if ( sameSuit ) {
            cards.sort((c1, c2) -> c2.value() - c1.value());
            boolean cardsInOrder = true; int i=0;
            while (i<cards.size()-1 && cardsInOrder){
                if ( cards.get(i).value() != cards.get(i+1).value() + 1) cardsInOrder = false;
                i++;
            }
            //cards are of same suit
            if (cardsInOrder) {
                pattern = Pattern.STRAIGHT_FLUSH;
                handValue = cards.get(0).value();
                return true;
            }

        }
       return false;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public int getValue() {
        return handValue;
    }
}
