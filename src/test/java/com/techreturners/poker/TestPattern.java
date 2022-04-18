package com.techreturners.poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPattern {

    @Test
    public void testStraightFlushRank(){
        Pattern rank = Pattern.STRAIGHT_FLUSH;
        assertEquals(1, rank.getPostion());
        assertEquals("Straight flush", rank.getDescription());
    }
}
