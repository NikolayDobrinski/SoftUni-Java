package softuni.advanced.stackandqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**Description:
 * Will be given an integer N representing the number of elements to enqueue (add),
 * an integer S representing the number of elements to dequeue (remove/poll) from the
 * queue and finally an integer X, an element that you should check whether is present
 * in the queue. If it is print true on the console,
 * if it’s not print the smallest element currently present in the queue.
 */

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbersInput = Arrays.stream(scan.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();

        int n = numbersInput[0];
        int s = numbersInput[1];
        int x = numbersInput[2];

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++) {
            queue.offer(numbers[i]);
        }

        while (s > 0 && !queue.isEmpty()) {
            queue.poll();
            s--;
        }

        if (queue.isEmpty()) {
            System.out.println("0");
        } else if (queue.contains(x)) {
            System.out.println("true");
        } else {
            int minElement = Collections.min(queue);
            System.out.println(minElement);
        }
    }
}
