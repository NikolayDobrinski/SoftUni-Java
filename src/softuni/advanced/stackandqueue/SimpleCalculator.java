package softuni.advanced.stackandqueue;

import java.util.ArrayDeque;
import java.util.Scanner;

/**Description:
 * Simple calculator that can evaluate simple expressions that will
 * not hold any operator different from addition and subtraction.
 */

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split("\\s+");

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (Character.isDigit(token.charAt(0))) {
                numbers.push(Integer.parseInt(token));
            } else {
                int rightOperand = Integer.parseInt(tokens[++i]);
                int leftOperand = numbers.peek();
                numbers.push(rightOperand);

                int result = token.equals("+")
                        ? leftOperand + rightOperand
                        : leftOperand - rightOperand;

                numbers.push(result);
            }
        }

        System.out.println(numbers.peek());

    }
}
