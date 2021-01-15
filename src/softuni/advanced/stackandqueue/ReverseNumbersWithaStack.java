package softuni.advanced.stackandqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**Description:
 * Program that reads N integers from the console and reverses them using a stack.
 */

public class ReverseNumbersWithaStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        List<Integer> inputData = Arrays.stream(scan.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        for (Integer integer : inputData) {
            numbersStack.push(integer);
        }

        while (!numbersStack.isEmpty()) {
            System.out.print(numbersStack.pop() + " ");
        }
    }
}
