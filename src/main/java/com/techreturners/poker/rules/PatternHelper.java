package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Pattern;

import java.util.List;

public interface PatternHelper {
    Pattern getName();

    boolean check(List<Card> cards);

    int getHandValue(List<Card> cards);

    int getNextValue(List<Card> cards, int no);
}
