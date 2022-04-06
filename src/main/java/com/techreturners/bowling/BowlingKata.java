package com.techreturners.bowling;

import java.util.Collections;
import java.util.List;

public class BowlingKata {


    public int calculateScore(List<char[]> frameList) {
        int score = 0;
        int[] frameScoreArr = new int[frameList.size()];
        for (int i = frameList.size()-1 ; i >= 0 ; i--) {
            for (char rollScore: frameList.get(i)) {
                if (Character.isDigit(rollScore)) {
                    frameScoreArr[i] += Character.getNumericValue(rollScore);
                }
                else if (rollScore == '/'){
                    frameScoreArr[i] = 10 + frameScoreArr[i+1];
                }
            }
        }
        for(int i= 0;i<10;i++) score += frameScoreArr[i];

        return score;
    }
}
