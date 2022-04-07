package com.techreturners.bowling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringInputConverter {
        String input;

        public StringInputConverter(String inputStr){
            input = inputStr;
        }

        public List<char[]> convert(){
            List<char[]> resultList = new ArrayList<>();
            String[] inputArr = input.split(" ");
            for (String frame:inputArr
                 ) {
                char[] frameChar = new char[frame.trim().length()];
                for (int i = 0; i < frame.trim().length(); i++) {
                    frameChar[i] = frame.charAt(i);
                }
                resultList.add(frameChar);
            }
            return resultList;
        }
}
