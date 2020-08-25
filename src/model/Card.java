package model;
/**
 * Card
 */
public class Card {
    private final int rank;
    private final int suit;

    public static final String SUITS[] = { "Clubs", "Diamonds", "Hearts", "Spades" };
    public static final String RANKS[] = { null, "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
            "King" };

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public boolean equals(Card that) {
        return this.rank == that.rank && this.suit == that.suit;
    }

    public int compareTo(Card that) {
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        if (this.rank < that.rank) {
            return -1;
        }
        if (this.rank > that.rank) {
            return 1;
        }
        return 0; // return 0 if cards are equal
    }

    public int getSuit() {
        return this.suit;
    }

    public int getRank() {
        return this.rank;
    }

    public String toString() {
        String cardString;
        if (rank == 0 || rank > 13) {
            return "ERROR";
        }
        if (suit > 3) {
            return "ERROR";
        }
        cardString = RANKS[this.rank] + " of " + SUITS[this.suit];
        return cardString;
    }

}