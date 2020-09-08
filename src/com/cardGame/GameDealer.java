package com.cardGame;

import java.math.BigInteger;
import java.util.Collections;

public class GameDealer {
    private CardDeck playDeck;
    private CardDeck marketDeck = new CardDeck();

    public GameDealer(){
        marketDeck.cardDeck.empty();
        this.playDeck = new CardDeck();

    }

    public CardDeck getMarketDeck() {
        return marketDeck;
    }

    public void setMarketDeck(CardDeck marketDeck) {
        this.marketDeck = marketDeck;
    }



    public CardDeck getPlayDeck() {
        return playDeck;
    }

    public void setPlayDeck(CardDeck playDeck) {
        this.playDeck = playDeck;
    }

    public void shuffleCards(){
        Collections.shuffle(playDeck.getCardDeck());
    }
    public void dealCards(byte noOfCards, Player player1, Player player2){
        for (byte i = BigInteger.ZERO.byteValueExact(); i<noOfCards; i++){
            player1.setPlayerCard(playDeck.getCardDeck().pop());
            player2.setPlayerCard(playDeck.getCardDeck().pop());
        }
        Card tempCard = playDeck.getCardDeck().pop();
        convertPlayDeckToMarketDeck();
        playDeck.getCardDeck().empty();
        playDeck.getCardDeck().push(tempCard);

     }


     public void convertPlayDeckToMarketDeck(){

         if (marketDeck.getCardDeck().isEmpty()){
             for (Card card : playDeck.getCardDeck()){
                 marketDeck.getCardDeck().push(playDeck.getCardDeck().pop());
             }
         }
     }


}
