package com.techreturners.poker.kata;


import java.util.*;

public class PokerHand
{
    public enum Result { TIE, WIN, LOSS }
    private final List<Card> cards = new ArrayList<>();
    private Pattern pattern = null;
    private Map<Suit, List<Card>> suitListMap = new HashMap<>();
    private Map<Integer, List<Card>> valueListMap = new HashMap<>();

    public PokerHand(String hand)
    {
        String[] cardsArr = hand.trim().split(" ");
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
        int result ;
        result =  hand.pattern.getPostion() - pattern.getPostion();
        if( result == 0){
            result = compareCards(hand);
        }
        return ( result > 0 ) ? Result.WIN : (result < 0 )? Result.LOSS : Result.TIE;
    }

    private List<Integer> getCardValuesSortedByPrecedence(){
        List<Integer> sortedValueOrder = new ArrayList<>(valueListMap.keySet());
        sortedValueOrder.sort((c1, c2)-> {
            return valueListMap.get(c1).size() == valueListMap.get(c2).size()?( c2 - c1 ):
                    valueListMap.get(c2).size() - valueListMap.get(c1).size() ; });
        return sortedValueOrder;
    }

    private int compareCards(PokerHand hand) {
        // compare the value of the paired hand
        // if equal compare the value of the next high card
        Result result ;
        List<Integer> cardValuesSorted = getCardValuesSortedByPrecedence();
        List<Integer> handCardValuesSorted = hand.getCardValuesSortedByPrecedence();

        int pairValue1 = 0 , pairValue2 = 0; //sort by keys.
        int i = 0;
        while ((pairValue1 == pairValue2) && (i < cardValuesSorted.size())) {
            pairValue1 = cardValuesSorted.get(i);
            pairValue2 = handCardValuesSorted.get(i);
            i++;
        }

        return pairValue1 - pairValue2;
    }


    private void setPattern() {
        pattern = determinePattern();
    }

    private Pattern determinePattern() {
        suitListMap = getCardsMapBySuit(cards);
        valueListMap = getCardsMapByValues(cards);
        boolean cardsInOrder = true; int i=0;
        while (i<cards.size()-1 && cardsInOrder){
            if ( cards.get(i).value() != cards.get(i+1).value() + 1)
                cardsInOrder = false;
            i++;
        }

        if (suitListMap.size() == 1 && cardsInOrder)  return Pattern.STRAIGHT_FLUSH;
        if (valueListMap.size() == 2) { // 5 cards split between 2 values
            for (List<Card> cardList : valueListMap.values()) {
                if ( cardList.size() == 4) return Pattern.FOUR_OF_A_KIND;
                if ( cardList.size() == 3) return Pattern.FULL_HOUSE;
            }
         }
       if (suitListMap.size() == 1) return Pattern.FLUSH;
       if (cardsInOrder) return Pattern.STRAIGHT;

       for (List<Card> cardList : valueListMap.values()) {
            if (cardList.size() == 3)  return Pattern.THREE_OF_A_KIND;
       }
       if (valueListMap.size() == 3 )  return Pattern.TWO_PAIRS;
       if (valueListMap.size() == 4)  return Pattern.ONE_PAIR;
       return  Pattern.HIGH_CARD;

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
        for (Card card : cards) {
            if (valueMap.containsKey(card.value()))  valueMap.get(card.value()).add(card);
            else {
                List<Card> clist = new ArrayList<>();
                clist.add(card);
                valueMap.put(card.value(),clist);
            }
        }
        return valueMap;
    }
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
