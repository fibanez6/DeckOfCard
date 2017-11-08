# DECK OF CARDS

## REQUIREMENTS
* Java
* Maven
* GIT

## Installation

```
  > git pull git@github.com:fibanez6/DeckOfCard.git
  > cd DeckOfCard
  > mvn clean install
```

## Execution

```
  > java -jar target/deck-of-cards-1.0-SNAPSHOT.jar
```


## Introduction

Write an interface for a deck of playing cards.

* Assume a standard 52 card deck & the card order is preserved after they have been shuffled.
* The desk has a top & a bottom

Include the methods

* Shuffle() – Restore the pack to a full deck and randomize the order of the cards.
* Draw() – remove a random card from the deck. A specific card once drawn cannot be drawn again.

Write Tests to
* Verify the functional behavior of the implementation
* Verify the non-functional behaviour of the implementation

Write an implementation of the class that compiles and passes the tests.

## IMPLEMENTATION

This project contains 2 implementations with different data structures. When you run the program, it will ask you which data structure to use.

* [Array](/src/main/java/com/fibanez/DeckArrayImpl.java)

  Deck of cards has a fixed size. When Draw() method is called, draw a random card and then shifts one position to the left all cards after the drawn card and set null the previous position of the last card shifted.
  
* [ArrayList](/src/main/java/com/fibanez/DeckArrayListImpl.java)

  Deck of card has a resizable size. When Draw() method is called, draw a random card and then remove it from the deck.

## Example

```
    > java -jar target/deck-of-cards-1.0-SNAPSHOT.jar
    > Please, insert a type deck [ARRAY | LIST]
    > ARRAY

```

### Output

```
> Drawing all cards from deck of type ARRAY
FOUR of DIAMONDS
TEN of DIAMONDS
ACE of HEARTS
SEVEN of SPADES
EIGHT of CLUBS
SEVEN of HEARTS
NINE of SPADES
SIX of DIAMONDS
TEN of HEARTS
SIX of SPADES
FIVE of HEARTS
KING of SPADES
THREE of HEARTS
FOUR of CLUBS
QUEEN of CLUBS
NINE of CLUBS
QUEEN of SPADES
QUEEN of DIAMONDS
KING of HEARTS
ACE of DIAMONDS
TEN of CLUBS
TWO of DIAMONDS
FIVE of CLUBS
KING of CLUBS
EIGHT of HEARTS
EIGHT of DIAMONDS
ACE of SPADES
JACK of HEARTS
KING of DIAMONDS
TEN of SPADES
THREE of DIAMONDS
NINE of DIAMONDS
FIVE of DIAMONDS
JACK of DIAMONDS
SIX of HEARTS
TWO of CLUBS
THREE of SPADES
ACE of CLUBS
JACK of SPADES
TWO of SPADES
SEVEN of CLUBS
FOUR of SPADES
QUEEN of HEARTS
EIGHT of SPADES
SIX of CLUBS
JACK of CLUBS
TWO of HEARTS
FIVE of SPADES
NINE of HEARTS
SEVEN of DIAMONDS
FOUR of HEARTS
THREE of CLUBS

Process finished with exit code 0
```