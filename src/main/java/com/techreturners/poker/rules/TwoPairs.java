package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TwoPairs implements  PatternHelper{
    @Override
    public Pattern getName() {
        return Pattern.TWO_PAIRS;
    }

    @Override
    public boolean check(List<Card> cards) {
        Map<Integer, List<Card>> valueMap = CardUtils.getCardsMapByValues(cards);
        return countListsWithTwoCards(valueMap) == 2;
    }

    @Override
    public int getHandValue(List<Card> cards) {
        return getNextValue(cards,1);
    }

    @Override
    public int getNextValue(List<Card> cards, int rank) {
        Map<Integer, List<Card>> valueMap = CardUtils.getCardsMapByValues(cards);
        int nextPair = 0;
        for (List<Card> cardList : valueMap.values()) {
            if (cardList.size() == 2) {
                if (rank == 1 ) {
                    if (cardList.get(0).value() > nextPair)
                        nextPair = cardList.get(0).value();
                }
                else if (rank ==2 ){
                    if (cardList.get(0).value() < nextPair || nextPair == 0)
                        nextPair = cardList.get(0).value();
                }
            }
            else if (rank == 3) {
                nextPair = cardList.get(0).value();
            }
        }
        return nextPair;
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
