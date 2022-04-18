package com.techreturners.poker;


public class Card {
    private final Suit suit;
    private int value;


    public Card(String cardStr) {
        setValue(cardStr.substring(0,1));
        suit = Suit.valueOf(cardStr.substring(1));
    }

    public Suit suit() {
        return suit;
    }

    public int value() {
        return value;
    }

    private void setValue(String cardValueStr){
        if (Character.isDigit(cardValueStr.charAt(0))){
            value =  Integer.parseInt(cardValueStr);
        }
        else {
            value = switch (cardValueStr){
                case "T" -> 10;
                case "J" -> 11;
                case "Q" -> 12;
                case "K" -> 13;
                case "A" -> 14;
                default -> throw new IllegalArgumentException("Unknown card denomination " + cardValueStr);
            };
        }
    }
}
