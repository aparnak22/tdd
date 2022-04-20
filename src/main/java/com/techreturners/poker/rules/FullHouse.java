package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Pattern;

import java.util.List;
import java.util.Map;

public class FullHouse implements PatternHelper{
    @Override
    public Pattern getName() {
        return Pattern.FULL_HOUSE;
    }

    @Override
    public boolean check(List<Card> cards) {
        Map<Integer, List<Card>> valueMap = CardUtils.getCardsMapByValues(cards);
        return getListWithNoOfSameValueCards(valueMap,3)!=null &&
                getListWithNoOfSameValueCards(valueMap,2)!=null;
    }

    @Override
    public int getHandValue(List<Card> cards) {
        List<Card> cardList =
                getListWithNoOfSameValueCards(
                        CardUtils.getCardsMapByValues(cards),3);
        if(cardList!=null){
            return cardList.get(0).value();
        }
        else return -1;
    }

    @Override
    public int getNextValue(List<Card> cards, int no) {
        return getHandValue(cards);
    }

    private List<Card> getListWithNoOfSameValueCards(Map<Integer, List<Card>> valueMap, int noOfSameValueCards) {
        for (List<Card> cardList : valueMap.values()) {
            if (cardList.size() == noOfSameValueCards) {
                return cardList;
            }
        }
        return null;
    }
}
