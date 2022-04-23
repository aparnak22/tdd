package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Pattern;
import com.techreturners.poker.Suit;

import java.util.*;

public class FourOfAKind implements  PatternHelper{
    @Override
    public Pattern getName() {
        return Pattern.FOUR_OF_A_KIND;
    }

    @Override
    public boolean check(List<Card> cards,  Map<Integer, List<Card>> valueListMap,
                         Map<Suit, List<Card>> suitListMap) {
        return getListWithFourCards(valueListMap) != null;
    }

    private List<Card> getListWithFourCards(Map<Integer, List<Card>> valueMap) {
        for (List<Card> cardList : valueMap.values()) {
            if (cardList.size() == 4) {
               return cardList;
            }
        }
        return null;
    }



}
