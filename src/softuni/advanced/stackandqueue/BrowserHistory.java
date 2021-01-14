package softuni.advanced.stackandqueue;

import java.util.ArrayDeque;
import java.util.Scanner;

/**Description:
 * Program which takes 2 types of browser instructions:
 * - Normal navigation: a URL is set, given by a string
 * - The string "back" that sets the current URL to the last set URL
 * After each instruction the program prints the current URL. If the back instruction can’t be executed, prints "no previous URLs".
 * The input ends with "Home" command.
 */

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String currentURL = "";

        ArrayDeque<String> stack = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (!stack.isEmpty()) {
                    currentURL = stack.pop();
                } else {
                    System.out.println("no previous URLs");
                    input = scan.nextLine();
                    continue;
                }
            } else {
                if (!currentURL.equals("")) {
                    stack.push(currentURL);
                }
                currentURL = input;
            }

            System.out.println(currentURL);
            input = scan.nextLine();
        }
    }
}
