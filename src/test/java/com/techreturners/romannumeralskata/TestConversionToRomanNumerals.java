package com.techreturners.romannumeralskata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestConversionToRomanNumerals {

    @Test
    public void testOneLetterConversion() {
        RomanNumeralConverter converter = new RomanNumeralConverter();
        assertEquals( "I" , converter.toRomanNumber(1));
        assertEquals( "V", converter.toRomanNumber(5));
        assertEquals( "X", converter.toRomanNumber(10));

    }

    @Test
    public void testTwoOrMoreLetterConversion() {
        RomanNumeralConverter converter = new RomanNumeralConverter();
        assertEquals( "III" , converter.toRomanNumber(3));
        assertEquals( "VII", converter.toRomanNumber(7));
        assertEquals( "IX", converter.toRomanNumber(9));
        assertEquals( "XI", converter.toRomanNumber(11));
        assertEquals( "XIV", converter.toRomanNumber(14));
        assertEquals( "XX", converter.toRomanNumber(20));


    }

    @Test
    public void test10sConversion() {
        RomanNumeralConverter converter = new RomanNumeralConverter();
        assertEquals( "XXX" , converter.toRomanNumber(30));
        assertEquals( "XL", converter.toRomanNumber(40));
        assertEquals( "L", converter.toRomanNumber(50));
        assertEquals( "LX", converter.toRomanNumber(60));
        assertEquals( "LXX", converter.toRomanNumber(70));
        assertEquals( "LXXX", converter.toRomanNumber(80));


    }
}
