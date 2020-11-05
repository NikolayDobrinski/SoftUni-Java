package softuni.fundamentals.exercise.fundamentals;

import java.util.Scanner;

public class Ages {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int age = Integer.parseInt(scan.nextLine());

        String result = "";

        if (age <= 2) {
            result = "baby";
        } else if (age <= 13) {
            result = "child";
        } else if (age <= 19) {
            result = "teenager";
        } else if (age <= 65) {
            result = "adult";
        } else if (age > 65) {
            result = "elder";
        }

        System.out.printf("%s", result);

    }
}
