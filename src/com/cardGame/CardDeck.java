package com.cardGame;

import java.util.Stack;

import static java.util.Collections.*;

public class CardDeck {
    Stack<Card> cardDeck = new Stack<>();


    public Stack<Card> getCardDeck() {
        return cardDeck;
    }

    public void setCardDeck(Stack<Card> cardDeck) {
        this.cardDeck = cardDeck;
    }

    public CardDeck() {
        for (int cardSuite = 1; cardSuite <= 5; cardSuite++) {
            for (int cardValue = 1; cardValue <= 14; cardValue++) {
                //CardSuite 1 and 2 represent Circles and Triangles respectively
                if (cardSuite == 1 || cardSuite == 2) {
                    if (cardValue == 6 || cardValue == 9) {
                        continue;
                    }
                }
                //CardSuite 3 and 4 represent Cross and Squares respectively
                if (cardSuite == 3 || cardSuite == 4) {
                    if (cardValue == 6 || cardValue == 9) {
                        continue;
                    }
                }
                //cardSuite 5 represent a Star
                if (cardSuite == 5) {
                    switch (cardValue) {
                        case 6:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            continue;

                    }

                }
                //cardSuite 6 represent Whot Card

                if (cardSuite == 6) {
                    if (cardValue > 5) {

                        break;
                    }
                }


                this.getCardDeck().push(new Card(cardSuite, cardValue));

            }


        }
    }

        public Card goMarket (CardDeck cardDeck) {
            return cardDeck.getCardDeck().pop();

        }
        public void shuffleCard (CardDeck cardDeck) {
            shuffle(cardDeck.getCardDeck());

        }

    }
