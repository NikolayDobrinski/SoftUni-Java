package softuni.fundamentals.exercise.dbvariables;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scan.nextLine());
        double biggestKeg = Double.MIN_VALUE;
        String winner = "";

        for (int i = 0; i < numberOfLines; i++) {
            String model = scan.nextLine();
            double radius = Double.parseDouble(scan.nextLine());
            int height = Integer.parseInt(scan.nextLine());

            double currentVolume = Math.PI * radius * radius * height;

            if (currentVolume > biggestKeg) {
                biggestKeg = currentVolume;
                winner = model;
            }

        }
        System.out.println(winner);

    }
}
