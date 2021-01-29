package softuni.advanced.functionalprogramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

/**Description:
 * Program that reads a collection of strings from the console and then prints them onto the console.
 * We have used a Consumer<T>.
 */

public class ConsumerPrint {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Consumer<String> consumer = name -> System.out.println(name);

        Arrays.stream(scan.nextLine().split("\\s+")).forEach(consumer);

    }
}
