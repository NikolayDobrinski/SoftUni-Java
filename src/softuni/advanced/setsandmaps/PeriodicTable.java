package softuni.advanced.setsandmaps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**Description:
 * We are given n number of chemical compounds that can be repeated.
 * We need to keep all the chemical elements used in the compounds and
 * finally print all the unique ones in ascending order.
 */

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfChemicalCompounds = Integer.parseInt(scan.nextLine());

        Set<String> chemicalCompounds = new TreeSet<>();

        for (int i = 0; i < numberOfChemicalCompounds; i++) {
            String[] currentCompound = scan.nextLine().split("\\s+");

            for (int j = 0; j < currentCompound.length; j++) {
                chemicalCompounds.add(currentCompound[j]);
            }

        }

        chemicalCompounds.forEach(e -> System.out.print(e + " "));

    }
}
