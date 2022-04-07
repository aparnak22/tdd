package com.techreturners.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingKata {
    
    List<char[]> bowlingFrameList = new ArrayList<>();

    public int calculateScore(String frameListStr) {

        StringInputConverter inputConverter = new StringInputConverter(frameListStr);
        return calculateScore(inputConverter.convert());

    }
    public int calculateScore(List<char[]> frameList) {
        int score = 0;
        int[][] throwScoreArr = new int[frameList.size()][3];
        int[] frameScoreArr = new int[frameList.size()];

        for (int i = frameList.size()-1 ; i >= 0 ; i--) {
            for(int k = 0; k< frameList.get(i).length;k++){
                char rollScore = frameList.get(i)[k];
                if (Character.isDigit(rollScore)) {
                    throwScoreArr[i][k] += Character.getNumericValue(rollScore);
                    frameScoreArr[i] +=throwScoreArr[i][k];
                }
                else if (rollScore == '/'){
                    throwScoreArr[i][k] = 10 - throwScoreArr[i][0];
                    if (i < frameList.size()-1)
                        frameScoreArr[i] +=  throwScoreArr[i][k]  + throwScoreArr[i+1][0];
                    else
                        frameScoreArr[i] += throwScoreArr[i][k];
                }
                else if (rollScore == 'X'){ //handle X on last frame and one on previous differntly!
                    throwScoreArr[i][k] = 10;
                    if (i < frameList.size()-1){
                        //Get first throw  from next frame.
                        frameScoreArr[i] =    throwScoreArr[i][k]  + throwScoreArr[i+1][0] ;
                        if (  frameList.get(i+1).length > 1 ) // if the next frame has a second throw
                            frameScoreArr[i] += throwScoreArr[i+1][1];
                        else if(i < frameList.size()-2) // Get first throw from next frame +1
                            frameScoreArr[i] += throwScoreArr[i+2][0];
                    }
                    else
                        frameScoreArr[i]  += throwScoreArr[i][k];
                }
            }
        }
        for(int i= 0;i<10;i++) {
           score += frameScoreArr[i];
        }

        return score;
    }

    public void addFrame(char[] frames) {
        bowlingFrameList.add(frames);
    }

    public int calculateScore(){
        return calculateScore(bowlingFrameList);
    }
}
