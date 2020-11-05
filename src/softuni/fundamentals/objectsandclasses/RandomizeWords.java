package softuni.fundamentals.objectsandclasses;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");
        Random rnd = new Random();

        for (int i = 0; i < input.length; i++) {
            String first = input[i];
            int randomNumber = rnd.nextInt(input.length);
            input[i] = input[randomNumber];
            input[randomNumber] = first;
        }
        for (String s : input) {
            System.out.println(s);
        }

    }
}
