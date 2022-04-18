package com.techreturners.poker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCard {

    @Test
    public void testNumberCardValue(){
        Card twos = new Card("2H");
        assertEquals(Suit.H , twos.suit());
        assertEquals(2, twos.value());

        Card threes = new Card("3D");
        assertEquals(Suit.D , threes.suit());
        assertEquals(3, threes.value());

        Card fours = new Card("4S");
        assertEquals(Suit.S , fours.suit());
        assertEquals(4, fours.value());

        Card fives = new Card("5C");
        assertEquals(Suit.C , fives.suit());
        assertEquals(5, fives.value());
    }

    @Test
    public void testFaceCardValue(){
        Card card1 = new Card("AH");
        assertEquals(Suit.H , card1.suit());
        assertEquals(14, card1.value());

        Card card2 = new Card("JS");
        assertEquals(Suit.S , card2.suit());
        assertEquals(11, card2.value());

        Card card3 = new Card("QC");
        assertEquals(Suit.C , card3.suit());
        assertEquals(12, card3.value());

        Card card4 = new Card("KD");
        assertEquals(Suit.D , card4.suit());
        assertEquals(13, card4.value());
    }

    @Test
    public void testCardSorting(){
        String[] cardsArr = "3H 5H 4H 6H 2H".split(" ");
        List<Card> cardList = new ArrayList<>();
        for (String cardStr : cardsArr
        ) {
            cardList.add(new Card(cardStr));
        }
        cardList.sort((c1, c2) -> c2.value() - c1.value());
        assertEquals(6, cardList.get(0).value());
        assertEquals(2, cardList.get(4).value());
    }
}
