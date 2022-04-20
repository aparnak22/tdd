package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Pattern;

import java.util.List;
import java.util.Map;

public class ThreeOfAKind implements  PatternHelper{
    @Override
    public Pattern getName() {
        return Pattern.THREE_OF_A_KIND;
    }

    @Override
    public boolean check(List<Card> cards) {
        Map<Integer, List<Card>> valueMap = CardUtils.getCardsMapByValues(cards);
        return getListWithThreeCards(valueMap) != null;
    }

    @Override
    public int getHandValue(List<Card> cards) {
        Map<Integer, List<Card>> valueMap = CardUtils.getCardsMapByValues(cards);
        List<Card> cardList = getListWithThreeCards(valueMap);
        if (cardList!=null)
            return cardList.get(0).value();
        else
            return -1;
    }

    @Override
    public int getNextValue(List<Card> cards, int no) {
        return getHandValue(cards);
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
