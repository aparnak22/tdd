 package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Pattern;
import com.techreturners.poker.Suit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OnePair implements  PatternHelper{
    @Override
    public Pattern getName() {
        return Pattern.ONE_PAIR;
    }

    @Override
    public boolean check(List<Card> cards,Map<Integer, List<Card>> valueListMap,
                         Map<Suit, List<Card>> suitListMap) {
        return valueListMap.size() == 4;
    }


}
