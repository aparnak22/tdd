package com.techreturners.poker;

public enum Pattern {

    STRAIGHT_FLUSH(1,"Straight flush"),
    FOUR_OF_A_KIND(2, "Four of a kind"),
    FULL_HOUSE(3,"Full house" ),
    FLUSH(4,"Flush"),
    THREE_OF_A_KIND(5, "Three of a kind"),
    TWO_PAIRS(6, "Two Pairs"),
    ONE_PAIR(7, "One Pair"),
    HIGHEST_CARD(8,"Highest card");


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

