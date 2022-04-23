package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Pattern;
import com.techreturners.poker.Suit;

import java.util.List;
import java.util.Map;

public interface PatternHelper {
    Pattern getName();

    boolean check(List<Card> cards,  Map<Integer, List<Card>> valueListMap,
                  Map<Suit, List<Card>> suitListMap);

}
