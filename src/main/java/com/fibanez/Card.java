package com.fibanez;

/**
 * Represents a card from a deck of standard playing cards
 *
 * @author fibanez
 */
public class Card {

    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }

    public enum Rank { TWO, THREE, FOUR, FIVE, SIX,
        SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }

    private final Suit suit;
    private final Rank rank;

    /**
     * Creates a new Card with the give Suit and Rank.
     *
     * @param suit Card's suit.
     * @param rank Card's rank.
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Returns this Card's rank value.
     *
     * @return rank value
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Returns this Card's suit value.
     *
     * @return suit value
     */
    public Suit getSuit() {
        return suit;
    }

    /*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
        return rank + " of " + suit + "  ";
    }

}
