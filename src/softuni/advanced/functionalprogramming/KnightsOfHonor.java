package softuni.advanced.functionalprogramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

/**Description:
 * Program that reads a collection of names as strings from the console and then appends “Sir”
 * in front of every name and prints it back onto the console.
 */

public class KnightsOfHonor {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Consumer<String> consumer = name -> System.out.println("Sir " + name);

        Arrays.stream(scan.nextLine().split("\\s+")).forEach(consumer);

    }
}
