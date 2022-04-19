package com.techreturners.poker;

import com.techreturners.poker.rules.PatternHelper;
import com.techreturners.poker.rules.RulesEvaluator;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards = new ArrayList<>();
    private PatternHelper patternHelper;
    private int handValue = -1;

    public Hand(String cardsInHand) {
        String[] cardsArr = cardsInHand.split(" ");
        for (String cardStr : cardsArr
             ) {
            cards.add(new Card(cardStr));
        }
        setPattern();
        if ( patternHelper!=null)
            handValue = patternHelper.getHandValue(cards);
    }

    private void setPattern() {
        //setStraightFlush();
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
}
