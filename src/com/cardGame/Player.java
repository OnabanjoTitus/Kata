package com.cardGame;

import java.util.ArrayList;
import java.util.List;


public class Player {
   // public GameDealer gameDealer;
    boolean isPlayerTurn;
    byte playerId=0;
    List<Card> playerCard = new ArrayList<>();

    public Player(){
        this.playerId++;
    }

    public List<Card> getPlayerCard() {
        return playerCard;
    }

    public void setPlayerCard(Card card) {
        this.playerCard.add(card);
    }

    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        isPlayerTurn = playerTurn;
    }

    public Card playCard(GameDealer gameDealer, Player player, Card card) {
       Card returnCard = gameDealer.getPlayDeck().getCardDeck().peek();
        if (card.compareTo(gameDealer.getPlayDeck().getCardDeck().peek()) == 0) {
            player.getPlayerCard().remove(card);
            gameDealer.getPlayDeck().getCardDeck().push(card);
                if (card.getCardValue()== 2){
                    this.isPlayerTurn = true;


                }
            if (card.getCardValue()== 1){
                this.isPlayerTurn = true;
            }
            if (card.getCardValue()== 14){
                this.isPlayerTurn = true;

            }
           returnCard = card;
        } else {
            System.err.print("Not equal Card");
            this.setPlayerTurn(true);
        }
        return returnCard;

    }
    public void goMarket(CardDeck marketDeck){
        setPlayerCard(marketDeck.goMarket(marketDeck));

    }
    public void displayCards(){
        for (Card card: this.playerCard){
            card.displayCard();
        }
    }
}
