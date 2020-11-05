package softuni.fundamentals.methodslab;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        printResult(Double.parseDouble(scan.nextLine()));

    }

    private static void printResult(double grade) {
        String output = "";

        if (2.00 <= grade && grade <= 2.99) {
            output = "Fail";
        } else if (3.00 <= grade && grade <= 3.49) {
            output = "Poor";
        } else if (3.50 <= grade && grade <= 4.49) {
            output = "Good";
        } else if (4.50 <= grade && grade <= 5.49) {
            output = "Very good";
        } else if (5.50 <= grade && grade <= 6.00) {
            output = "Excellent";
        }
        System.out.println(output);

    }

}


