package com.techreturners.poker.kata;


import javax.management.Query;
import java.util.*;

public class PokerHand
{
    public enum Result { TIE, WIN, LOSS }
    private final List<Card> cards = new ArrayList<>();
    private Pattern pattern = null;

    public PokerHand(String hand)
    {
        String[] cardsArr = hand.split(" ");
        for (String cardStr : cardsArr
        ) {
            cards.add(new Card(cardStr));
        }
        cards.sort(Card::compareTo);
        setPattern();

    }

    public Result compareWith(PokerHand hand) {
        /*
         * check pokerHandPatternRank
         * if rank equal check pokerhandValue
         * Pattern rank depends on combination of cards
         * hand value depends upon pattern
         */
        Result result = Result.TIE;
        if (pattern.getPostion()  < hand.pattern.getPostion()){
            result = Result.WIN;
        }
        else if (pattern.getPostion()  > hand.pattern.getPostion()){
            result = Result.LOSS;
        }
        else {
            if (pattern == Pattern.ONE_PAIR){
                result = compareOnePair(hand);
            }
            else {
                int p1Value = getNextHighValue();
                int p2Value = hand.getNextHighValue();
                int rank = 0;
                while (rank < 4 && p1Value == p2Value) {
                    p1Value = getNextHighValue();
                    p2Value = hand.getNextHighValue();
                    rank++;
                }
                if (p1Value > p2Value) {
                    result = Result.WIN;
                } else if (p1Value < p2Value) {
                    result = Result.LOSS;
                } else {
                    result = Result.TIE;
                }
            }
        }
        return result;
    }

    private Result compareOnePair(PokerHand hand) {
        // compare the value of the paired hand
        // if equal compare the value of the next high card
        Result result = Result.TIE ;

        int pairValue1 = 0 , pairValue2 = 0;
        List<Card> nonPairedList = new ArrayList<>();
        for (List<Card> cardList : valueListMap.values()) {
            if (cardList.size() == 2)
                pairValue1 = cardList.get(0).value();
            else
                nonPairedList.add(cardList.get(0));
        }
        List<Card> handNonPairedList = new ArrayList<>();
        for (List<Card> cardList : hand.valueListMap.values()) {
            if (cardList.size() == 2)
                pairValue2 = cardList.get(0).value();
            else
                handNonPairedList.add(cardList.get(0));
        }
        if ( pairValue1 > pairValue2){
            result = Result.WIN;
        }
        else if (pairValue1 < pairValue2){
            result = Result.LOSS;
        }
        else {
            nonPairedList.sort(Card::compareTo);
            handNonPairedList.sort(Card::compareTo);
            int i = 0;
            while ((pairValue1 == pairValue2) && (i < nonPairedList.size())) {
                pairValue1 = nonPairedList.get(i).value();
                pairValue2 = handNonPairedList.get(i).value();
                i++;
            }
            if ( pairValue1 > pairValue2){
                result = Result.WIN;
            }
            else if (pairValue1 < pairValue2){
                result = Result.LOSS;
            }
        }
        return result;
    }

    private Map<Suit, List<Card>> suitListMap = new HashMap<>();
    private Map<Integer, List<Card>> valueListMap = new HashMap<>();

    private void setPattern() {

        pattern = determinePattern();
    }

    private Pattern determinePattern() {
        suitListMap = getCardsMapBySuit(cards);
        valueListMap = getCardsMapByValues(cards);
        if (suitListMap.size() == 1) {
            //one suit only
            boolean cardsInOrder = true; int i=0;
            while (i<cards.size()-1 && cardsInOrder){
                if ( cards.get(i).value() != cards.get(i+1).value() + 1)
                    cardsInOrder = false;
                i++;
            }
            if (cardsInOrder) return Pattern.STRAIGHT_FLUSH;
        }
        if  (valueListMap.size() == 2) { // 5 cards split between 2 values
            for (List<Card> cardList : valueListMap.values()) {
                if (cardList.size() == 4) {//4 cards of same value
                    return Pattern.FOUR_OF_A_KIND;
                }
                else if (cardList.size() == 3){// 3 cards of same value which implies other 2 cards make a pair
                    return Pattern.FULL_HOUSE;
                }
            }
       }
       if (suitListMap.size() == 1){
            return Pattern.FLUSH;
       }
        boolean cardsInOrder = true; int i=0;
        while (i<cards.size()-1 && cardsInOrder){
            if ( cards.get(i).value() != cards.get(i+1).value() + 1)
                cardsInOrder = false;
            i++;
        }
        if (cardsInOrder) return Pattern.STRAIGHT;

       for (List<Card> cardList : valueListMap.values()) {
            if (cardList.size() == 3){// 3 cards of same value
                return Pattern.THREE_OF_A_KIND;
            }
       }
       if ( valueListMap.size() == 3 ){
            return Pattern.TWO_PAIRS;
       }
       if (valueListMap.size() == 4) {
           //contains one pair
           return Pattern.ONE_PAIR;
       }
       return  Pattern.HIGH_CARD;

    }

    int valueRank =0 ;
    public int getNextHighValue() {
        int nextValue = -1;
        if (pattern == Pattern.STRAIGHT_FLUSH) {
            nextValue =  cards.get(valueRank).value();
        }
        else if (pattern == Pattern.FOUR_OF_A_KIND){
                for (List<Card> cardList : valueListMap.values()) {
                    if (cardList.size() == 4) {
                        if ( valueRank == 0 )
                            nextValue = cardList.get(0).value();
                    }
                    else {
                        if ( valueRank > 0)
                            nextValue = cardList.get(0).value();
                    }
                }
        }
        else if (pattern == Pattern.FULL_HOUSE || pattern == Pattern.THREE_OF_A_KIND){
                List<Card> nonGroupedCards = new ArrayList<>();
                for (List<Card> cardList : valueListMap.values()) {
                    if (cardList.size() == 3) {
                        if (valueRank == 0)
                            nextValue = cardList.get(0).value();
                    }
                    else {
                            nonGroupedCards.add(cardList.get(0));
                    }
                }
                if (valueRank > 0 ){
                    nonGroupedCards.sort(Card::compareTo);
                    nextValue = nonGroupedCards.get(0).value();
                }
        }
        else if (pattern == Pattern.TWO_PAIRS) {
            int maxPairValue = 0;
            for (List<Card> cardList : valueListMap.values()) {
                if (valueRank < 2 && cardList.size() == 2) {
                    if (maxPairValue == 0){
                        maxPairValue = cardList.get(0).value();
                    }
                    else if ( valueRank == 0 ) {
                        if (cardList.get(0).value() > maxPairValue)
                            maxPairValue = cardList.get(0).value();
                    }
                    else {
                        if (cardList.get(0).value() < maxPairValue)
                            maxPairValue = cardList.get(0).value();
                    }
                }
                else if (valueRank >=2  &&  cardList.size() == 1){
                    maxPairValue = cardList.get(0).value();
                }
            }
            nextValue = maxPairValue;
        }
        else nextValue =  cards.get(valueRank).value(); //high card, flush, straight

        if ( valueRank < 5 ){
            valueRank++;
        }
        return nextValue;
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

class Hand {
    private final List<Card> cards = new ArrayList<>();
    private Pattern pattern;
    private int handValue = -1;

    public Hand(String cardsInHand) {
        String[] cardsArr = cardsInHand.split(" ");
        for (String cardStr : cardsArr
        ) {
            cards.add(new Card(cardStr));
        }
      /*  setPattern();
        if ( patternHelper!=null)
            handValue = patternHelper.getHandValue(cards);*/
    }

    private void setPattern(Pattern p) {
        //setStraightFlush();
        //patternHelper = RulesEvaluator.evaluateHand(cards);
        pattern = p;
    }


    public List<Card> getCards() {
        return cards;
    }

    public  Pattern getPattern() {
        return pattern;
    }

    public int getValue() {
        return handValue;
    }

 /*   public int getNextValue(int rank) {
        return patternHelper.getNextValue(cards, rank);
    }*/
}

class Card implements Comparable<Card> {
    private final Suit suit;
    private int value;


    public Card(String cardStr) {
        setValue(cardStr.substring(0, 1));
        suit = Suit.valueOf(cardStr.substring(1));
    }

    public Suit suit() {
        return suit;
    }

    public int value() {
        return value;
    }

    private void setValue(String cardValueStr) {
        if (Character.isDigit(cardValueStr.charAt(0))) {
            value = Integer.parseInt(cardValueStr);
        } else {
            value = switch (cardValueStr) {
                case "T" -> 10;
                case "J" -> 11;
                case "Q" -> 12;
                case "K" -> 13;
                case "A" -> 14;
                default -> throw new IllegalArgumentException("Unknown card denomination " + cardValueStr);
            };
        }
    }


    @Override
    public int compareTo(Card c) {
        return c.value() - value();
    }
}
enum Suit {
    D, H, C, S
}

enum Pattern {

    STRAIGHT_FLUSH(1,"Straight flush"),
    FOUR_OF_A_KIND(2, "Four of a kind"),
    FULL_HOUSE(3,"Full house" ),
    FLUSH(4,"Flush"),
    STRAIGHT(5,"Straight"),
    THREE_OF_A_KIND(6, "Three of a kind"),
    TWO_PAIRS(7, "Two Pairs"),
    ONE_PAIR(8, "One Pair"),
    HIGH_CARD(9,"High card");


    private final int position;
    private final String description;

    Pattern(int position, String description) {
        this.position = position;
        this.description = description;
    }

    public int getPostion() {
        return position;
    }

    public String getDescription(){
        return description;
    }
}
