package softuni.advanced.functionalprogramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 * We have to write a program using UnaryOperator<Double> that reads one line of Double prices separated by ", "
 * and prints the prices with added VATs for all of them.
 */

public class AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        UnaryOperator<Double> vatAdder = val -> val * 1.20;

        System.out.println("Prices with VAT:");

        String values = Arrays.stream(scan.nextLine().split(", "))
                .map(e -> String.format("%.2f", vatAdder.apply(Double.parseDouble(e))))
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(values);

    }
}
