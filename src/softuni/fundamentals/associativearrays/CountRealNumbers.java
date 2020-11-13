package softuni.fundamentals.associativearrays;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Double, Integer> list = new TreeMap<>();
        String[] numbersAsStrings = scan.nextLine().split(" ");

        for (int i = 0; i < numbersAsStrings.length; i++) {
            double number = Double.parseDouble(numbersAsStrings[i]);

            Integer occurrences = list.get(number);

            if (occurrences == null) {
                occurrences = 0;
            }
            list.put(number, 1 + occurrences);
        }
        for (Map.Entry<Double, Integer> entry : list.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.####");
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }


    }
}
