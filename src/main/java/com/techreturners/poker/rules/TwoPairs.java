package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Pattern;
import com.techreturners.poker.Suit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TwoPairs implements  PatternHelper{
    @Override
    public Pattern getName() {
        return Pattern.TWO_PAIRS;
    }

    @Override
    public boolean check(List<Card> cards,Map<Integer, List<Card>> valueListMap,
                         Map<Suit, List<Card>> suitListMap) {
        return countListsWithTwoCards(valueListMap) == 2;
    }

    private int countListsWithTwoCards(Map<Integer, List<Card>> valueMap) {
        int twoPairs = 0;
        for (List<Card> cardList : valueMap.values()) {
            if (cardList.size() == 2) {
               twoPairs ++;
            }
        }
        return twoPairs;
    }



}
