package softuni.fundamentals.methodsexercise;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String nString = scan.nextLine();
        int n = Integer.parseInt(nString);

        int sumDigits = 0;
        int counterOddDigit = 0;

        for (int i = 1; i <= n; i++) {
            String convertToString = Integer.toString(i);
            for (int j = 0; j < convertToString.length(); j++) {

                int current = convertToString.charAt(j) - 48;
                if (current % 2 != 0) {
                    counterOddDigit++;
                }
                sumDigits += current;
            }
            if (sumDigits % 8 == 0 && counterOddDigit > 0) {
                System.out.println(i);
                sumDigits = 0;
                counterOddDigit = 0;
            } else {
                sumDigits = 0;
                counterOddDigit = 0;
            }
        }
    }
}
