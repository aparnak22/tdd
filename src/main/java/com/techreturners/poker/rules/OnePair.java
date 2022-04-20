 package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OnePair implements  PatternHelper{
    @Override
    public Pattern getName() {
        return Pattern.ONE_PAIR;
    }

    @Override
    public boolean check(List<Card> cards) {
        Map<Integer, List<Card>> valueMap = CardUtils.getCardsMapByValues(cards);
        return countListsWithTwoCards(valueMap) == 1;
    }

    @Override
    public int getHandValue(List<Card> cards) {

        return getNextValue(cards,1);
    }

    @Override
    public int getNextValue(List<Card> cards, int rank) {
       int nextValue  = 0;
       Map<Integer, List<Card>> cardListMap = CardUtils.getCardsMapByValues(cards);
       List<Card> nonPairedList = new ArrayList<>();
       for (List<Card> cardList : cardListMap.values()) {
            if ( rank == 1 && cardList.size()==2)
                return cardList.get(0).value();
            else if (cardList.size() == 1) {
                nonPairedList.add(cardList.get(0));
            }
        }
       nonPairedList.sort(Card::compareTo);
       if (rank-2 < cards.size())
            return nonPairedList.get(rank-2).value();
       else
           return 0;

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
