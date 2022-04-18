package com.techreturners.poker;

public enum Pattern {

    STRAIGHT_FLUSH(1,"Straight flush");

    private int position;
    private String description;

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
