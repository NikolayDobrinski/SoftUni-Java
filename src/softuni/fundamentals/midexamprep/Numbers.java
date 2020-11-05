package softuni.fundamentals.midexamprep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String numbers = scan.nextLine();

        int[] array = parseArray(numbers);

        double averageNum = averageNum(array);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] > averageNum) {
                result.add(array[i]);
            }
        }
        if (result.isEmpty()) {
            System.out.println("No");
        } else {

            Collections.sort(result);
            Collections.reverse(result);

            for (int i = 0; i < Math.min(result.size(), 5); i++) {
                System.out.print(result.get(i) + " ");
            }
        }

    }

    private static double averageNum(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        double average = sum / array.length;
        return average;
    }

    private static int[] parseArray(String numbers) {
        String[] numbersAsString = numbers.split(" ");
        int[] array = new int[numbersAsString.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(numbersAsString[i]);
        }
        return array;
    }
}
