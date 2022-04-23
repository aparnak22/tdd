package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Pattern;
import com.techreturners.poker.Suit;

import java.util.List;
import java.util.Map;

public class ThreeOfAKind implements  PatternHelper{
    @Override
    public Pattern getName() {
        return Pattern.THREE_OF_A_KIND;
    }

    @Override
    public boolean check(List<Card> cards, Map<Integer, List<Card>> valueListMap,
                         Map<Suit, List<Card>> suitListMap	) {
        return getListWithThreeCards(valueListMap) != null;
    }


    private List<Card> getListWithThreeCards(Map<Integer, List<Card>> valueMap) {
        for (List<Card> cardList : valueMap.values()) {
            if (cardList.size() == 3) {
               return cardList;
            }
        }
        return null;
    }



}
