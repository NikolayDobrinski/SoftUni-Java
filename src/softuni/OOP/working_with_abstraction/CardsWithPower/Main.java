package softuni.OOP.working_with_abstraction.CardsWithPower;

import java.util.Scanner;

/**
 * Description:
 * We have to create a program that generates a deck of cards (class Card) which have a power.
 * The power of a card is calculated by adding the power of its rank plus the power of its suit.
 * On the first line we will receive the Rank of the card and on the second line we will get the suit of the card.
 * Rank powers are as follows: (ACE - 14, TWO - 2, THREE - 3, FOUR - 4, FIVE - 5, SIX - 6, SEVEN - 7,
 * EIGHT - 8, NINE - 9, TEN - 10, JACK - 11, QUEEN - 12, KING - 13).
 * Suit powers are as follows: (CLUBS - 0, DIAMONDS - 13, HEARTS - 26, SPADES - 39).
 */

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String cardRank = scan.nextLine();
        String cardSuit = scan.nextLine();

        Card card = new Card(CardRank.valueOf(cardRank), CardSuit.valueOf(cardSuit));

        System.out.println(card.toString());

    }
}
