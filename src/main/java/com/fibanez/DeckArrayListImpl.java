package com.fibanez;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *  An object of type Deck represents a deck of playing cards.  The deck
 *  is a regular poker deck that contains 52 regular cards.
 *
 *  It uses ArrayList as data structure
 *
 * @author fibanez
 */
public class DeckArrayListImpl implements Deck {

    private final int maxNumberOfCards;

    private final List<Card> cards;

    private Random rnd = new Random();

    public DeckArrayListImpl() {
        this.maxNumberOfCards = Card.Rank.values().length * Card.Suit.values().length;
        this.cards = new ArrayList<>(maxNumberOfCards);
        reset();
    }

    @Override
    public int cardsLeft() {
        return cards.size();
    }

    @Override
    public Card getTopCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.get(0);
    }

    @Override
    public Card getBottomCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.get(cards.size() -1);
    }

    @Override
    public Card draw() {
        int index;
        Card card;
        if (cards.isEmpty()) {
            return null;
        } else if (cards.size() == 1) {
            index = 0;
        } else {
            index = rnd.nextInt(cards.size()-1);
        }
        card = cards.get(index);
        cards.remove(index);
        return card;
    }

    @Override
    public void shuffle() {
        reset();
        Collections.shuffle(cards);
    }

    @Override
    public void reset() {
        cards.clear();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards.add( new Card(suit,rank) );
            }
        }
    }
}
