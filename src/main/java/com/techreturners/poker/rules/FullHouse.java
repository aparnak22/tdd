package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Pattern;
import com.techreturners.poker.Suit;

import java.util.List;
import java.util.Map;

public class FullHouse implements PatternHelper{
    @Override
    public Pattern getName() {
        return Pattern.FULL_HOUSE;
    }

    @Override
    public boolean check(List<Card> cards,  Map<Integer, List<Card>> valueListMap,
                         Map<Suit, List<Card>> suitListMap) {

        if (valueListMap.size() == 2) { // 5 cards split between 2 values
            for (List<Card> cardList : valueListMap.values()) {
                if ( cardList.size() == 3) return true;
            }
        }
        return false;
    }

}
