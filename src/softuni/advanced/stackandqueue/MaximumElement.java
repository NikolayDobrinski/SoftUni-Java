package softuni.advanced.stackandqueue;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

/**Description:
 * Will be given N commands. Each command is one of the following types:
 * "1 X" - Push the element X into the stack.
 * "2" - Delete the element present at the top of the stack.
 * "3" - Print the maximum element in the stack.
 */

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int n = Integer.parseInt(scan.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] line = scan.nextLine().split(" ");
            String command = line[0];

            switch (command) {
                case "1":
                    int numberToPush = Integer.parseInt(line[1]);
                    stack.push(numberToPush);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    int maxNumber = Collections.max(stack);
                    System.out.println(maxNumber);
                    break;
            }
        }
    }
}
