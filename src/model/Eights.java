package model;

import java.util.Scanner;

public class Eights {

    private Player one;
    private Player two;
    private Hand drawPile;
    private Hand discardPile;
    private Scanner keyboard;

    public Eights() {
        ExtendedDeck deck = new ExtendedDeck("deck");
        deck.shuffle();
        int cardsPerhand = 7;

        one = new Player("Trevin");
        deck.deal(one.getHand(), cardsPerhand);

        two = new Player("bot");
        deck.deal(two.getHand(), cardsPerhand);

        // places 1 card face up
        discardPile = new Hand("Discard Pile");
        deck.deal(discardPile, 1);

        drawPile = new Hand("Draw Pile");
        deck.dealAll(drawPile);

        keyboard = new Scanner(System.in);
    }

    public boolean isDone() {
        return one.getHand().isEmpty() || two.getHand().isEmpty();
    }

    // when the drawPile is empty we need to re-shuffle
    public void reshuffle() {
        Card prev = discardPile.popCard();
        discardPile.dealAll(drawPile);
        discardPile.addCard(prev);
        drawPile.shuffle();
    }

    public Card drawCard() {
        if (drawPile.isEmpty()) {
            reshuffle();
        }
        return discardPile.popCard();
    }

    public Player nextPlayer(Player current) {
        if (current == one) {
            return two;
        } else {
            return one;
        }
    }

    public void displayState() {
        one.display();
        two.display();
        discardPile.display();
        System.out.printf("The draw pile has %d cards. \n", drawPile.size());
        System.out.println("----------------------------------------------------------------");
        keyboard.nextLine();
    }

    public void takeTurn(Player players) {
        Card prev = discardPile.lastCard();
        Card next = players.play(this, prev);
        discardPile.addCard(next);

        System.out.println(players.getName() + " plays " + next);
        System.out.println();
    }

    public void playGame() {
        Player player = one;

        while (!isDone()) {
            displayState();
            takeTurn(player);
            player = nextPlayer(player);
        }

        one.displayScore();
        two.displayScore();
    }
}