package com.fibanez;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author fibanez
 */
public class CardTest {

    private Card.Suit suitTest;
    private Card.Rank rankTest;

    private Card card;

    @Before
    public void setUp() throws Exception {
        this.suitTest = Card.Suit.CLUBS;
        this.rankTest = Card.Rank.ACE;

        this.card = new Card(suitTest,rankTest);
    }

    @After
    public void tearDown() throws Exception {
        this.card = null;
    }

    @Test
    public void testCreateCard() {
        Assert.assertNotNull(card);
    }

    @Test
    public void testSuitValue() {
        Assert.assertEquals(suitTest, card.getSuit());
    }

    @Test
    public void testRankValue() {
        Assert.assertEquals(rankTest, card.getRank());
    }

    @Test
    public void testToString() {
        String valueExpected = suitTest + " of " + rankTest;
        Assert.assertNotNull(valueExpected, card.toString());
    }

}
