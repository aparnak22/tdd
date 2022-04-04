package com.techreturners.romannumeralskata;

import java.util.*;

public class RomanNumeralConverter {

    Map<Integer,String> romanNumeralsLetterMap = new TreeMap<>();

    public RomanNumeralConverter(){
        romanNumeralsLetterMap.put(1,"I");
        romanNumeralsLetterMap.put(4,"IV");
        romanNumeralsLetterMap.put(5,"V");
        romanNumeralsLetterMap.put(9,"IX");
        romanNumeralsLetterMap.put(10,"X");
        romanNumeralsLetterMap.put(40,"XL");
        romanNumeralsLetterMap.put(50,"L");
        romanNumeralsLetterMap.put(90 ,"XC");
        romanNumeralsLetterMap.put(100,"C");
        romanNumeralsLetterMap.put(400 ,"CD");
        romanNumeralsLetterMap.put(500,"D");
        romanNumeralsLetterMap.put(900 ,"CM");
        romanNumeralsLetterMap.put(1000 ,"M");
    }

    public String toRomanNumber(int decimalNumber) {
        StringBuilder rnStr = new StringBuilder();
        int differencePending = decimalNumber;
        Set<Map.Entry<Integer, String>> romanLetters = romanNumeralsLetterMap.entrySet();
        Map.Entry<Integer, String> nextEntry, highestMatch = null;

        while (differencePending > 0) {
              Iterator<Map.Entry<Integer, String>> itr = romanLetters.iterator();
              while (itr.hasNext() && ( nextEntry= itr.next()).getKey() <= differencePending ){
                    highestMatch = nextEntry;
              }
            if (highestMatch != null) {
                rnStr.append(highestMatch.getValue());
                differencePending = differencePending - highestMatch.getKey();
            }
        }
        return rnStr.toString();
    }


}
