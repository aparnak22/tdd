package com.techreturners.poker.rules;

import com.techreturners.poker.Card;
import com.techreturners.poker.Suit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardUtils {

    public static Map<Integer, List<Card>> getCardsMapByValues(List<Card> cards){
        Map<Integer, List<Card>> valueMap = new HashMap<>();
        for (Card card :
                cards) {
            if (valueMap.containsKey(card.value())){
                valueMap.get(card.value()).add(card);
            }
            else {
                List<Card> clist = new ArrayList<>();
                clist.add(card);
                valueMap.put(card.value(),clist);
            }
        }
        return valueMap;
    }

    public static Map<Suit, List<Card>> getCardsMapBySuit(List<Card> cards){
        Map<Suit, List<Card>> suitMap = new HashMap<>();
        for (Card card :
                cards) {
            if (suitMap.containsKey(card.suit())){
                suitMap.get(card.suit()).add(card);
            }
            else {
                List<Card> clist = new ArrayList<>();
                clist.add(card);
                suitMap.put(card.suit(),clist);
            }
        }
        return suitMap;
    }
}
