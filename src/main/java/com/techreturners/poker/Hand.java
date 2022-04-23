package com.techreturners.poker;

import com.techreturners.poker.rules.CardUtils;
import com.techreturners.poker.rules.PatternHelper;
import com.techreturners.poker.rules.RulesEvaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Hand {
    private final List<Card> cards = new ArrayList<>();
    private PatternHelper patternHelper;
    private int handValue = -1;
    private final Map<Integer, List<Card>> valueListMap;
    public Hand(String cardsInHand) {
        String[] cardsArr = cardsInHand.split(" ");
        for (String cardStr : cardsArr
             ) {
            cards.add(new Card(cardStr));
        }
        valueListMap = CardUtils.getCardsMapByValues(cards);
        setPattern();
        if ( patternHelper!=null)
            handValue = patternHelper.getHandValue(cards);
    }

    private void setPattern() {
        patternHelper = RulesEvaluator.evaluateHand(cards);
    }


    public List<Card> getCards() {
        return cards;
    }

    public Pattern getPattern() {
        return patternHelper.getName();
    }

    public int getValue() {
        return handValue;
    }

    public int getNextValue(int rank) {
        return patternHelper.getNextValue(cards, rank);
    }


    public int compareWith(Hand hand) {
        // compare the value of the paired hand
        // if equal compare the value of the next high card
        int result ;
        result = hand.getPattern().getPostion() - getPattern().getPostion();

        if ( result == 0) {
            List<Integer> cardValuesSorted = getCardValuesSortedByPrecedence();
            List<Integer> handCardValuesSorted = hand.getCardValuesSortedByPrecedence();

            int pairValue1 = 0 , pairValue2 = 0; //sort by keys.
            int i = 0;
            while ((pairValue1 == pairValue2) && (i < cardValuesSorted.size())) {
                pairValue1 = cardValuesSorted.get(i);
                pairValue2 = handCardValuesSorted.get(i);
                i++;
            }
            result = pairValue1 - pairValue2;
        }
        return result;
    }

    private List<Integer> getCardValuesSortedByPrecedence(){
        List<Integer> sortedValueOrder = new ArrayList<>(valueListMap.keySet());
        sortedValueOrder.sort((c1, c2)-> {
            return valueListMap.get(c1).size() == valueListMap.get(c2).size()?( c2 - c1 ):
                    valueListMap.get(c2).size() - valueListMap.get(c1).size() ; });
        return sortedValueOrder;
    }
}
