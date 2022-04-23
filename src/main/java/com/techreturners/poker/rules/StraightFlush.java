package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Pattern;
import com.techreturners.poker.Suit;

import java.util.List;
import java.util.Map;

public class StraightFlush implements PatternHelper {

    @Override
    public Pattern getName(){
        return Pattern.STRAIGHT_FLUSH;
    }

    @Override
    public boolean check(List<Card> cards, Map<Integer, List<Card>> valueListMap,
                         Map<Suit, List<Card>> suitListMap ) {

        boolean sameSuit = (suitListMap.size() == 1);

        if ( sameSuit ) {
            cards.sort(Card::compareTo);
            boolean cardsInOrder = true; int i=0;
            while (i<cards.size()-1 && cardsInOrder){
                if ( cards.get(i).value() != cards.get(i+1).value() + 1)
                    cardsInOrder = false;
                i++;
            }
            return cardsInOrder;
        }
        return false;
    }

}
