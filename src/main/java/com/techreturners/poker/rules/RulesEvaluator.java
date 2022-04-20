package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Pattern;

import java.util.List;

public class RulesEvaluator {

    private static final PatternHelper[] rulesListInOrder = new PatternHelper[]{
                                new StraightFlush(),
                                new FourOfAKind(),
                                new FullHouse()};




    public static PatternHelper evaluateHand(List<Card> cardList){
        int i=0; boolean patternFound ;
        while(i<rulesListInOrder.length ){
            patternFound = rulesListInOrder[i].check(cardList);
            if (patternFound){
                return rulesListInOrder[i];
            }
            i++;
        }
        return null;
    }

}
