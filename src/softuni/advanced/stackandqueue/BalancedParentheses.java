package softuni.advanced.stackandqueue;

import java.util.ArrayDeque;
import java.util.Scanner;

/**Description:
 * Given a sequence consisting of parentheses, determine whether the expression is balanced.
 * A sequence of parentheses is balanced if every open parenthesis can be paired uniquely with
 * a closed parenthesis that occurs after the former. Also, the interval between them must be balanced.
 * Will be given three types of parentheses: (, {, and [.
 * {[()]} - This is a balanced parenthesis.
 * {[(])} - This is not a balanced parenthesis.
 */

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String sequence = scan.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean areBalanced = true;

        for (int i = 0; i < sequence.length(); i++) {
            char current = sequence.charAt(i);

            if (current == '[' || current == '{' || current == '(') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    areBalanced = false;
                    break;
                }
                char topElement = stack.pop();
                if (current == ']' && topElement != '[') {
                    areBalanced = false;
                    break;
                } else if (current == '}' && topElement != '{') {
                    areBalanced = false;
                    break;
                } else if (current == ')' && topElement != '(') {
                    areBalanced = false;
                    break;
                }
            }
        }
        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
