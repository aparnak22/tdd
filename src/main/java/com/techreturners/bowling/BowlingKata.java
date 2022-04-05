package com.techreturners.bowling;

import java.util.List;

public class BowlingKata {


    public int calculateScore(List<char[]> frameList) {

        int score = 0;

        for (char[] frame : frameList) {
            for (char rollScore: frame) {
                if (Character.isDigit(rollScore)){
                    score+=Integer.valueOf(String.valueOf(rollScore));
                }
            }
        }
        return score;
    }
}
