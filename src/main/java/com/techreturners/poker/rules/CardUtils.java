package com.techreturners.poker.rules;

import com.techreturners.poker.Card;

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
}
