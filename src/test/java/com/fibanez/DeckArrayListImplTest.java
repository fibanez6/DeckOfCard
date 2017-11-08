package com.fibanez;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

/**
 * @author fibanez
 */
public class DeckArrayListImplTest {

    private DeckArrayListImpl deck;

    @Before
    public void setUp() throws Exception {
        this.deck = new DeckArrayListImpl();
    }

    @After
    public void tearDown() throws Exception {
        this.deck = null;
    }

    @Test
    public void testCreateDeck() {
        Assert.assertNotNull(deck);
    }

    @Test
    public void testHas52cards() {
        Assert.assertEquals(52, deck.cardsLeft());
    }

    @Test
    public void testHasATopCard() {
        Assert.assertNotNull(deck.getTopCard());
    }

    @Test
    public void testHasABottomCard() {
        Assert.assertNotNull(deck.getBottomCard());
    }

    @Test
    public void testNotNullDrawCard() {
        Card card = deck.draw();
        Assert.assertNotNull(card);
    }

    @Test
    public void testDecreasedDeckSizeAfterDrawingCard() {
        int previousSize = deck.cardsLeft();
        deck.draw();
        int currentSize = deck.cardsLeft();
        Assert.assertEquals(previousSize-1,currentSize);
    }

    @Test
    public void testDrawAllDeck() {
        while (deck.cardsLeft() > 0) {
            deck.draw();
        }
        Assert.assertEquals(0,deck.cardsLeft());
    }

    @Test
    public void testNoDuplicatedInDrawingCards() {
        HashSet<Card> subtractedCards = new HashSet();

        Card drawnCard;
        while (deck.cardsLeft() > 0) {
            drawnCard = deck.draw();
            if (subtractedCards.contains(drawnCard)) {
                Assert.fail("Duplicated card: "+drawnCard.toString());
            }
        }
    }

    @Test
    public void testResetFromEmptyDeck() {
        while (deck.cardsLeft() > 0) {
            deck.draw();
        }

        Assert.assertEquals(0, deck.cardsLeft());
        deck.reset();
        Assert.assertEquals(52, deck.cardsLeft());
    }

    @Test
    public void testShuffleTenTimesThenCheckRandomizedOrder() {
        Card previousTopCard = deck.getTopCard();
        Card previousBottomCard = deck.getBottomCard();

        for (int i = 0; i < 10; i++) {
            deck.shuffle();
        }

        Card currentTopCard = deck.getTopCard();
        Assert.assertNotEquals(currentTopCard, previousTopCard);
        Card currentBottomCard = deck.getBottomCard();
        Assert.assertNotEquals(currentBottomCard, previousBottomCard);
    }

    @Test
    public void testEmptyThenResetDeckCheckHasAllCards() {
        // draw all cards
        while (deck.cardsLeft() > 0) {
            deck.draw();
        }
        int deckSize = deck.cardsLeft();
        Assert.assertEquals(0, deckSize);

        // Reset deck
        deck.shuffle();
        deckSize = deck.cardsLeft();
        Assert.assertEquals(52, deckSize);
    }

    @Test
    public void testDrawHigherNumCardsThanDeckSizeThenNextDrawCardIsNull() {
        // draw all cards
        while (deck.cardsLeft() > 0) {
            deck.draw();
        }
        Card card = deck.draw();
        Assert.assertNull(card);
    }

    @Test
    public void testEmptyDeckThenGetNullCardFromTheTop() {
        // draw all cards
        while (deck.cardsLeft() > 0) {
            deck.draw();
        }
        Card card = deck.getTopCard();
        Assert.assertNull(card);
    }

    @Test
    public void testEmptyDeckThenGetNullCardFromBottom() {
        // draw all cards
        while (deck.cardsLeft() > 0) {
            deck.draw();
        }
        Card card = deck.getBottomCard();
        Assert.assertNull(card);
    }

}
