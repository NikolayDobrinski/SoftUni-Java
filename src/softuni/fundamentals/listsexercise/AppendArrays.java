package softuni.fundamentals.listsexercise;

import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\|");

        String output = "";
        for (int i = input.length - 1; i >= 0; i--) {
            String[] current = input[i].split("\\s+");
            for (int j = 0; j < current.length; j++) {
                if (!current[j].equals("")) {
                    output += current[j] + " ";
                }
            }
        }
        System.out.println(output);
    }
}
