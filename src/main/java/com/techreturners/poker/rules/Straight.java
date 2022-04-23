package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Pattern;
import com.techreturners.poker.Suit;

import java.util.List;
import java.util.Map;

public class Straight implements PatternHelper {

    @Override
    public Pattern getName(){
        return Pattern.STRAIGHT;
    }

    @Override
    public boolean check(List<Card> cards, Map<Integer, List<Card>> valueListMap,
                         Map<Suit, List<Card>> suitListMap) {
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
