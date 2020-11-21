package softuni.fundamentals.textprocessing;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");
        String firstString = input[0];
        String secondString = input[1];

        int sum = calculatesSumOfStringsCharacterCodesMultiplied(firstString, secondString);
        System.out.println(sum);
    }

    private static int calculatesSumOfStringsCharacterCodesMultiplied(String first, String second) {
        int sum = 0;
        int shorterString = Math.min(first.length(), second.length());

        for (int i = 0; i < shorterString; i++) {
            sum += first.charAt(i) * second.charAt(i);
        }
        if (first.length() > second.length()) {
            for (int i = second.length(); i < first.length(); i++) {
                sum += first.charAt(i);
            }
        } else {
            for (int i = first.length(); i < second.length(); i++) {
                sum += second.charAt(i);
            }
        }
        return sum;
    }
}
