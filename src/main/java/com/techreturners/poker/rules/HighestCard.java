package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Pattern;

import java.util.List;

public class HighestCard implements PatternHelper {


    @Override
    public Pattern getName() {
        return Pattern.HIGHEST_CARD;
    }

    /**
     * Hands which do not fit any higher category are ranked by the value of their highest card.
     * @param cards
     * @return
     */
    @Override
    public boolean check(List<Card> cards) {
        return true;
    }

    @Override
    public int getHandValue(List<Card> cards) {
        return getNextValue(cards,1);
    }

    @Override
    public int getNextValue(List<Card> cards, int no) {
        cards.sort(Card::compareTo);
        return cards.get(no-1).value();
    }
}
