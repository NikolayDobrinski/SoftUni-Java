package softuni.OOP.CardSuit;

/** Description:
 * We have to create an enumeration type that has as its constants the four suits of a deck of playing cards (CLUBS,
 * DIAMONDS, HEARTS, SPADES). Then, iterate over the values of the enumeration type and print all ordinal values and names.
 */

public class Main {
    public static void main(String[] args) {

        CardSuit[] cardSuits = CardSuit.values();
        System.out.println("Card Suits:");
        for (CardSuit cardSuit: cardSuits) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s", cardSuit.ordinal(), cardSuit.name()));
        }
    }
}
