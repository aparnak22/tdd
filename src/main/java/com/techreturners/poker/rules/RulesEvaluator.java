package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Suit;

import java.util.List;
import java.util.Map;

public class RulesEvaluator {

    private static final PatternHelper[] rulesListInOrder = new PatternHelper[]{
                                new StraightFlush(),
                                new FourOfAKind(),
                                new FullHouse(),
                                new Flush(),
                                new Straight(),
                                new ThreeOfAKind(),
                                new TwoPairs(),
                                new OnePair(),
                                new HighCard()};




    public static PatternHelper evaluateHand(List<Card> cardList,
                                             Map<Integer, List<Card>> valueListMap,
                                             Map<Suit, List<Card>> suitListMap){
        int i=0; boolean patternFound ;
        while(i<rulesListInOrder.length ){
            patternFound = rulesListInOrder[i].check(cardList, valueListMap, suitListMap);
            if (patternFound){
                return rulesListInOrder[i];
            }
            i++;
        }
        return null;
    }

}
