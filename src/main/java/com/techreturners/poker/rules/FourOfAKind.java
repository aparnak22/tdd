package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Pattern;

import java.util.*;

public class FourOfAKind implements  PatternHelper{
    @Override
    public Pattern getName() {
        return Pattern.FOUR_OF_A_KIND;
    }

    @Override
    public boolean check(List<Card> cards) {
        Map<Integer, List<Card>> valueMap = CardUtils.getCardsMapByValues(cards);
        return getListWithFourCards(valueMap) != null;
    }

    @Override
    public int getHandValue(List<Card> cards) {
        Map<Integer, List<Card>> valueMap = CardUtils.getCardsMapByValues(cards);
        List<Card> cardList = getListWithFourCards(valueMap);
        if (cardList!=null)
            return cardList.get(0).value();
        else
            return -1;
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
