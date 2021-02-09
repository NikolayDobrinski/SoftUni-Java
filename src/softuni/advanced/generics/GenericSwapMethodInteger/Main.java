package softuni.advanced.generics.GenericSwapMethodInteger;

import java.util.Arrays;
import java.util.Scanner;

/* Description:
 * We have to create a generic method that receives a list containing any type of data and swaps
 * the elements at two given indexes. We have to read n number of boxes of type Integer and add
 * them to the list. On the next line, we will receive a swap command consisting of two indexes.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Box<Integer> box = new Box<>();

        for (int i = 0; i < n; i++) {
            Integer value = Integer.parseInt(scan.nextLine());
            box.addValue(value);
        }
        int[] indexes = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int indexOne = indexes[0];
        int indexTwo = indexes[1];
        box.swap(indexOne, indexTwo);
        System.out.println(box);
    }
}
