package com.fibanez;

/**
 * An interface for a deck of cards.
 *
 * @author fibanez
 */
public interface Deck {

    /**
     * Returns the number of cards that are still left in the deck. It decreases
     * by 1 each time the dealCard() method is called.
     *
     * @return number of cards in the deck.
     */
    int cardsLeft();

    /**
     * Returns the card from the top of the deck. It does not remove the card
     * from the deck.
     *
     * @return The first card from the desk, or <code>null</code> if the deck
     * is empty.
     */
    Card getTopCard();

    /**
     * Returns the card from the bottom of the deck. It does not remove  the
     * card from the deck.
     *
     * @return The last card from the desk, or <code>null</code> if the deck
     * is empty.
     */
    Card getBottomCard();

    /**
     * Draws and returns a random card from the deck.
     *
     * Once a card has been drawn, it is no longer in the deck and can't be
     * drawn again and the card order is preserved. After repeated calls to
     * draw() the deck will be empty and the method will return null.
     *
     * @return The next Card from the deck, or <code>null</code> if the deck
     * is empty.
     */
    Card draw();

    /**
     * Shuffles the deck. Restore the pack to a full deck and randomize  the
     * order of the cards.
     */
    void shuffle();

    /**
     * Restore the pack to a full deck
     */
    void reset();
}
