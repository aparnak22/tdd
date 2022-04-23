package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Pattern;
import com.techreturners.poker.Suit;

import java.util.List;
import java.util.Map;

public class HighCard implements PatternHelper {
   @Override
    public Pattern getName() {
        return Pattern.HIGH_CARD;
    }

    /**
     * Hands which do not fit any higher category are ranked by the value of their highest card.
     */
    @Override
    public boolean check(List<Card> cards, Map<Integer, List<Card>> valueListMap,
                         Map<Suit, List<Card>> suitListMap) {
        return true;
    }
}
