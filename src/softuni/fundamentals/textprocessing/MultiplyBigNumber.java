package softuni.fundamentals.textprocessing;

import java.util.Scanner;

/**
 * Multiply really big number with digit without using the BigInteger class.
 */

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String bigNumber = scan.nextLine().replaceAll("^0+", "");
        int digit = Integer.parseInt(scan.nextLine());

        if (digit == 0) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        int residue = 0;

        for (int i = bigNumber.length() - 1; i >= 0; i--) {
            int currentDigit = Integer.parseInt(String.valueOf(bigNumber.charAt(i)));
            int result = currentDigit * digit + residue;

            if (i == 0) {
                sb.insert(0, result);
            } else {
                int resDigit = result % 10;
                residue = result / 10;
                sb.insert(0, resDigit);
            }
        }
        System.out.println(sb);

    }
}
