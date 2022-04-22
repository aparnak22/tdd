package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Pattern;

import java.util.List;

public class Straight implements PatternHelper {

    @Override
    public Pattern getName(){
        return Pattern.STRAIGHT;
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
        cards.sort(Card::compareTo);
        boolean cardsInOrder = true;
        for (int i = 0; cardsInOrder && (i<cards.size()-1) ; i++) {
            if (cards.get(i).value() != (cards.get(i+1).value() + 1)) {
                cardsInOrder = false;
            }
        }
        return cardsInOrder;
    }

}
