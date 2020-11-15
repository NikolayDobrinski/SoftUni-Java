package softuni.fundamentals.associativearrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Character, Integer> chars = new LinkedHashMap<>();

        String input = scan.nextLine();

        for (char symbol : input.toCharArray()) {
            if (symbol != ' ') {
                if (chars.containsKey(symbol)) {
                    int count = chars.get(symbol);
                    chars.put(symbol, count + 1);
                } else {
                    chars.put(symbol, 1);
                }
            }
        }
        chars.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
