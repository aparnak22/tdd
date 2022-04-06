package com.techreturners.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingKata {
    
    List<char[]> bowlingFrameList = new ArrayList<>();

    public int calculateScore(List<char[]> frameList) {
        int score = 0;
        int[] frameScoreArr = new int[frameList.size()];
        for (int i = frameList.size()-1 ; i >= 0 ; i--) {
            for (char rollScore: frameList.get(i)) {
                if (Character.isDigit(rollScore)) {
                    frameScoreArr[i] += Character.getNumericValue(rollScore);
                }
                else if (rollScore == '/'){
                    frameScoreArr[i] = 10;
                    if (i < frameList.size()-1)
                         frameScoreArr[i] += frameScoreArr[i+1];
                }
                else if (rollScore == 'X'){
                    frameScoreArr[i] = 10;
                    if (i < frameList.size()-2)
                        frameScoreArr[i] += frameScoreArr[i+1] + frameScoreArr[i+2];
                }
            }
        }
        for(int i= 0;i<10;i++) score += frameScoreArr[i];

        return score;
    }

    public void addFrame(char[] frames) {
        bowlingFrameList.add(frames);
    }

    public int calculateScore(){
        return calculateScore(bowlingFrameList);
    }
}
