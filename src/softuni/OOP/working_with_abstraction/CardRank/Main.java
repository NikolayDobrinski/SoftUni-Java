package softuni.OOP.working_with_abstraction.CardRank;

/** Description:
 * We have to create an enumeration type that has as its constants the fourteen ranks of a deck of playing cards
 * (ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING). We have to iterate over the
 * values of the enumeration type and print all ordinal values and names.
 */

public class Main {
    public static void main(String[] args) {

        CardRank[] cardRanks = CardRank.values();
        System.out.println("Card Ranks:");
        for (CardRank card: cardRanks) {
            int ordinal = card.ordinal();
            String name = card.name();
            System.out.println(String.format("Ordinal value: %d; Name value: %s", ordinal, name));
        }
    }
}
