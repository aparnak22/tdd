package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Pattern;

import java.util.List;

public class StraightFlush implements PatternHelper {

    @Override
    public Pattern getName(){
        return Pattern.STRAIGHT_FLUSH;
    }


    @Override
    public int getHandValue(List<Card> cards) {
        return getNextValue(cards, 0);
    }

    @Override
    public int getNextValue(List<Card> cards, int no) {
        return cards.get(no).value();
    }

    @Override
    public boolean check(List<Card> cards) {
        boolean sameSuit = true;

        for (int i = 1; i < cards.size() && sameSuit; i++) {
            if ( cards.get(0).suit() != cards.get(i).suit() ){
                sameSuit = false;
            }
        }
        if ( sameSuit ) {
            cards.sort((c1, c2) -> c2.value() - c1.value());
            boolean cardsInOrder = true; int i=0;
            while (i<cards.size()-1 && cardsInOrder){
                if ( cards.get(i).value() != cards.get(i+1).value() + 1)
                    cardsInOrder = false;
                i++;
            }
            //cards are of same suit
            return cardsInOrder;

        }
        return false;
    }

}
