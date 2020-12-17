package softuni.fundamentals.finalexamprep;

import java.util.Scanner;

/**Description:
 * You will receive the amount of batches that you need to bake. For every batch you will receive ingredients:
 * flour, sugar and cocoa in grams. You need to calculate how many boxes of cookies you get for every batch
 * with the given ingredients and total boxes of cookies for all batches.
 */

public class SantasCookies {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int totalBoxes = 0;

        for (int i = 0; i < n; i++) {
            int flour = Integer.parseInt(scan.nextLine()) / 140;
            int sugar = Integer.parseInt(scan.nextLine()) / 20;
            int cocoa = Integer.parseInt(scan.nextLine()) / 10;

            if (flour > 0 && sugar > 0 && cocoa > 0) {

                int numberCookies = 0;

                if (flour <= sugar && flour <= cocoa) {
                    numberCookies = (170 * flour / 25);
                } else if (sugar <= flour && sugar <= cocoa) {
                    numberCookies = (170 * sugar / 25);
                } else {
                    numberCookies = (170 * cocoa / 25);
                }

                totalBoxes += numberCookies / 5;

                System.out.printf("Boxes of cookies: %d%n", numberCookies / 5);

            } else {
                System.out.println("Ingredients are not enough for a box of cookies.");
            }
        }
        System.out.printf("Total boxes: %d", totalBoxes);
    }
}
