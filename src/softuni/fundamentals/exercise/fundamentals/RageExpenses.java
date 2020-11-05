package softuni.fundamentals.exercise.fundamentals;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lostGames = Integer.parseInt(scan.nextLine());
        double headsetPrice = Double.parseDouble(scan.nextLine());
        double mousePrice = Double.parseDouble(scan.nextLine());
        double keyboardPrice = Double.parseDouble(scan.nextLine());
        double displayPrice = Double.parseDouble(scan.nextLine());

        double expenses = 0;
        int counterKeybords = 0;

        for (int i = 1; i <= lostGames; i++) {

            if (i % 2 == 0) {
                expenses += headsetPrice;
            }
            if (i % 3 == 0) {
                expenses += mousePrice;
            }
            if (i % 2 == 0 && i % 3 == 0) {
                expenses += keyboardPrice;
                counterKeybords++;
                if (counterKeybords == 2) {
                    expenses += displayPrice;
                    counterKeybords = 0;
                }
            }
        }
        System.out.printf("Rage expenses: %.2f lv.", expenses);


    }
}
