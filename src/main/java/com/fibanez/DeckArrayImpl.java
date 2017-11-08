package com.fibanez;

/**
 *  An object of type Deck represents a deck of playing cards.  The deck
 *  is a regular poker deck that contains 52 regular cards.
 *
 *  It uses Array as data structure
 *
 * @author fibanez
 */
public class DeckArrayImpl implements Deck {

    private Card[] cards;

    /**
     * Keeps track of the number of cards that have been drawn from
     * the deck so far.
     */
    private int cardsDrawn;

    public DeckArrayImpl() {
        int maxNumberOfCards = Card.Rank.values().length * Card.Suit.values().length;
        cards = new Card[maxNumberOfCards];
        reset();
    }

    @Override
    public int cardsLeft() {
        return cards.length - cardsDrawn;
    }

    @Override
    public Card getTopCard() {
        return cards[0];
    }

    @Override
    public Card getBottomCard() {
        int numCardLeft = cardsLeft();
        if (numCardLeft == 0) {
            return null;
        }
        return cards[numCardLeft-1];
    }

    /**
     * {@inheritDoc}
     *
     * To preserve the order, it shifts one position to the left all cards
     * after the drawn card and set null the previous position of the last
     * card shifted.
     */
    @Override
    public Card draw() {
        int numCardLeft = cardsLeft();
        if (numCardLeft == 0) {
            return null;
        } else {
            int drawIndex = (int)(Math.random() * numCardLeft);
            Card drawn = cards[drawIndex];
            for (int i = drawIndex + 1; i < numCardLeft; i++) {
                if (cards[i] == null) {
                    break;
                }
                cards[i - 1] = cards[i];
            }
            cardsDrawn++;
            cards[numCardLeft-1] = null;
            return drawn;
        }
    }

    @Override
    public void shuffle() {
        reset();
        for ( int i = cards.length-1; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            swap(i, rand);
        }
    }

    /**
     * Swap positions between 2 cards.
     */
    private void swap(int i, int j) {
        Card temp = cards[i];
        cards[i] = cards[j];
        cards[j] = temp;
    }

    @Override
    public void reset() {
        cardsDrawn = 0;
        int cardCounter = 0; // How many cards have been created so far.
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards[cardCounter] = new Card(suit,rank);
                cardCounter++;
            }
        }
    }
}
