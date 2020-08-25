package client;

import model.Card;
import model.Eights;

public class Driver {
    public static void main(String[] args) throws Exception {

        Eights gameOfEights = new Eights();
        gameOfEights.playGame();

        // deckofcards.shuffle();
        // deckofcards.print();
        // System.out.println("--------------------------------------------------------------");
        // deckofcards.selectionSort();
        // deckofcards.print();
        // Deck sorted = deckofcards.mergeSort();
        // sorted.print();
        // deckofcards.insertSort();
        // deckofcards.print();
        // Card[] cardpack1 = makeDeck();
        // Card threeofspades = new Card(3, 3);
        // printDeck(cardpack1);
        // System.out.println(binarySearchForCard(cardpack2, threeofspades));

    }

    public static Card[] makeDeck() {
        Card[] deckOfCards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                deckOfCards[index] = new Card(rank, suit);
                index++;
            }
        }
        return deckOfCards;
    }

    public static int binarySearchForCard(Card[] cards, Card target) {
        int low = 0;
        int high = cards.length - 1;

        while (low <= high) {
            System.out.println(low + ", " + high);
            int mid = (low + high) / 2;
            int comparison = cards[mid].compareTo(target);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int sequentialSearchForCard(Card[] cards, Card target) {
        for (int i = 0; i < cards.length; i++) {
            System.out.println(i);
            if (cards[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void printDeck(Card[] cards) {
        for (Card populatedCardArr : cards) {
            System.out.println(populatedCardArr);
        }
    }
}
