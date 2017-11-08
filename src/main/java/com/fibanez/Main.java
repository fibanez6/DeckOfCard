package com.fibanez;

import java.util.Scanner;

/**
 * @author fibanez
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please, insert a type deck [ARRAY | LIST]");

        String deckTypeInput = scan.nextLine();

        Deck deck = DeckFactory.getDeck(deckTypeInput);

        if (deck == null) {
            System.err.println("Invalid deck type");
            System.exit(-1);
        }

        System.out.println("Drawing all cards from deck of type " + deckTypeInput);

        Card card;
        while (deck.cardsLeft() > 0) {
            card = deck.draw();
            System.out.println(card);
        }

        System.exit(0);
    }
}
