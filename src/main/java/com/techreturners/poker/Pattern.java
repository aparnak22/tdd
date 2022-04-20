package com.techreturners.poker;

public enum Pattern {

    STRAIGHT_FLUSH(1,"Straight flush"),
    FOUR_OF_A_KIND(2, "Four of a kind"),
    FULL_HOUSE(3,"Full house" ),
    FLUSH(4,"Flush"),
    HIGHEST_CARD(10,"Highest card");


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
