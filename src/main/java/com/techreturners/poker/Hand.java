package com.techreturners.poker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Hand {
    private final List<Card> cards = new ArrayList<>();

    public Hand(String cardsInHand) {
        String[] cardsArr = cardsInHand.split(" ");
        for (String cardStr : cardsArr
             ) {
            cards.add(new Card(cardStr));
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}
