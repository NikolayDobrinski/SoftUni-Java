package softuni.fundamentals.exercise.dbvariables;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int startingYield = Integer.parseInt(scan.nextLine());

        int dayCounter = 0;
        int totalYield = 0;

        while (startingYield >= 100) {

            totalYield += (startingYield - 26);
            dayCounter++;

            startingYield -= 10;
        }
        if (totalYield > 26) {
            totalYield -= 26;
        }

        System.out.println(dayCounter);
        System.out.println(totalYield);


    }
}
