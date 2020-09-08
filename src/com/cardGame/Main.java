package com.cardGame;

import java.util.Scanner;

public class Main {
    static Scanner userInput = new Scanner(System.in);
    static GameDealer gameDealer = new GameDealer();
    static Player player1 = new Player();
    static Player player2 = new Player();

    public static void main(String[] args) {
        byte playOption;
        gameDealer.shuffleCards();
        ;
        gameDealer.dealCards((byte)5, player1, player2);

        while (!player1.playerCard.isEmpty() && !player2.playerCard.isEmpty()){
            Main.playCard(player1);

            Main.playCard(player2);


        }



    }

    public static void playCard(Player player) {
        byte playOption;
        System.out.println("current play Card: " + gameDealer.getPlayDeck().cardDeck.peek().getCardSuite() + " " + gameDealer.getPlayDeck().cardDeck.peek().getCardValue());
        System.out.println( "Player " +player.playerId+ " Cards");

        player.displayCards();
        System.out.println(" Choose the your card");
        playOption = userInput.nextByte();
        if (playOption < player.playerCard.size()) {
            player.playCard(gameDealer, player, player.getPlayerCard().get(playOption));
        }
        else{
            player.goMarket(gameDealer.getMarketDeck());
            player.isPlayerTurn= false;
                if (player == player1){
                    playCard(player2);
                }
                else
                    playCard(player1);
        }
    }
}
