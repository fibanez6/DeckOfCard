package com.fibanez;

/**
 * Factory to generate object of type Deck
 *
 * @author fibanez
 */
public class DeckFactory {

    /**
     * Return an object of the type deck or <code>null</code> if
     * deck type does not match with a existing deck.
     *
     * @param deckType type deck
     * @return object of type deck.
     */
    public static Deck getDeck(String deckType){
        if(deckType == null){
            return null;
        }
        if(deckType.equalsIgnoreCase("ARRAY")){
            return new DeckArrayImpl();

        } else if(deckType.equalsIgnoreCase("LIST")){
            return new DeckArrayListImpl();
        }

        return null;
    }

}
