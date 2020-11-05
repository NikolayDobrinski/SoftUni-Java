package softuni.fundamentals.exercise.dbvariables;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String number = scan.nextLine();
        int sum = 0;

        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            sum += (digit - 48);
        }
        System.out.println(sum);

    }
}
