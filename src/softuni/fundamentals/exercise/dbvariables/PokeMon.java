package softuni.fundamentals.exercise.dbvariables;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pokePower = Integer.parseInt(scan.nextLine());
        int distance = Integer.parseInt(scan.nextLine());
        int exaustionFactor = Integer.parseInt(scan.nextLine());

        int currentPokePower = pokePower;
        int counter = 0;

        while (currentPokePower >= distance) {
            currentPokePower -= distance;
            counter++;

            if (currentPokePower == pokePower * 0.5 && exaustionFactor != 0) {
                currentPokePower /= exaustionFactor;
            }
        }

        System.out.println(currentPokePower);
        System.out.println(counter);

    }
}
