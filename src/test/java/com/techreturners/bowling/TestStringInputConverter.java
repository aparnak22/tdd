package com.techreturners.bowling;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestStringInputConverter {


    @Test
    public void testInputStringWithNoStrikes(){
        String input = "11 22 33 44 55 66 77 88 99 00";
        char[][] resultArr = { {'1','1'},{'2','2'},{'3','3'},{'4','4'},
                {'5','5'},{'6','6'},{'7','7'},{'8','8'},
                {'9','9'}, {'0','0'}};
        List<char[]> expectedList = Arrays.asList(resultArr);

        StringInputConverter inputFormatter = new StringInputConverter(input);
        List<char[]> resultList = inputFormatter.convert();

        assertEquals(expectedList.size(), resultList.size());

        for (int i = 0; i <expectedList.size() ; i++) {
            assertArrayEquals(expectedList.get(i),resultList.get(i));
        }
    }

    @Test
    public void testInputStringWithStrikes(){
        String input = "X 22 33 44 55 66 77 88 99 XXX";
        char[][] resultArr = { {'X'},{'2','2'},{'3','3'},{'4','4'},
                {'5','5'},{'6','6'},{'7','7'},{'8','8'},
                {'9','9'}, {'X','X','X'}};
        List<char[]> expectedList = Arrays.asList(resultArr);

        StringInputConverter inputFormatter = new StringInputConverter(input);
        List<char[]> resultList = inputFormatter.convert();

        assertEquals(expectedList.size(), resultList.size());

        for (int i = 0; i <expectedList.size() ; i++) {
            assertArrayEquals(expectedList.get(i),resultList.get(i));
        }
    }



    @Test
    public void testInputStringWithStrikesAndSpares(){
        String input = "X X 9/ 80 X X 90 8/ 7/ 44";
        char[][] resultArr = { {'X'},{'X'},{'9','/'},{'8','0'},{'X'},
                {'X'},{'9','0'},{'8','/'},{'7','/'},
                {'4','4'}};
        List<char[]> expectedList = Arrays.asList(resultArr);

        StringInputConverter inputFormatter = new StringInputConverter(input);
        List<char[]> resultList = inputFormatter.convert();

        assertEquals(expectedList.size(), resultList.size());

        for (int i = 0; i <expectedList.size() ; i++) {
            assertArrayEquals(expectedList.get(i),resultList.get(i));
        }
    }

    @Test
    public void testAllStrikesInputConversion(){
        String input = "X X X X X X X X X XXX";
        char[][] resultArr = { {'X'},{'X'},{'X'},{'X'},{'X'},{'X'},{'X'},{'X'},{'X'},{'X','X','X'}};
        List<char[]> expectedList = Arrays.asList(resultArr);

        StringInputConverter inputFormatter = new StringInputConverter(input);
        List<char[]> resultList = inputFormatter.convert();

        assertEquals(expectedList.size(), resultList.size());

        for (int i = 0; i <expectedList.size() ; i++) {
            assertArrayEquals(expectedList.get(i),resultList.get(i));
        }
    }
}
