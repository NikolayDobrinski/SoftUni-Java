package softuni.advanced.stackandqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Description:
 * You will be given an integer N representing the number of elements to push onto the stack,
 * an integer S representing the number of elements to pop from the stack and finally an integer X,
 * an element that you should check whether is present in the stack.
 * If it is, print true on the console.
 * If it’s not, print the smallest element currently present in the stack.
 */

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbersInput = Arrays.stream(scan.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();

        int n = numbersInput[0];
        int s = numbersInput[1];
        int x = numbersInput[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++) {
            stack.push(numbers[i]);
        }

        while (s > 0 && !stack.isEmpty()) {
            stack.pop();
            s--;
        }

        if (stack.isEmpty()) {
            System.out.println("0");
        }
        else if (stack.contains(x)) {
            System.out.println("true");
        } else {
            int minElement = Collections.min(stack);
            System.out.println(minElement);
        }

    }
}
