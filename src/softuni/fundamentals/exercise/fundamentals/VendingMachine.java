package softuni.fundamentals.exercise.fundamentals;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String commandStart = scan.nextLine();

        double sumCoins = 0;

        while (!commandStart.equals("Start")) {

            double insertedCoins = Double.parseDouble(commandStart);

            double convertedCoins = insertedCoins * 10;

            if (convertedCoins == 1 || convertedCoins == 2 || convertedCoins == 5
                    || convertedCoins == 10 || convertedCoins == 20) {

                sumCoins += convertedCoins;
            } else {
                System.out.printf("Cannot accept %.2f%n", insertedCoins);
            }
            commandStart = scan.nextLine();
        }

        String selectDrink = scan.nextLine();

        while (!selectDrink.equals("End")) {

            if (selectDrink.equals("Nuts")) {
                if (sumCoins >= 20) {
                    sumCoins -= 20;
                    System.out.println("Purchased Nuts");
                } else {
                    System.out.println("Sorry, not enough money");
                }

            } else if (selectDrink.equals("Water")) {
                if (sumCoins >= 7) {
                    sumCoins -= 7;
                    System.out.println("Purchased Water");
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (selectDrink.equals("Crisps")) {
                if (sumCoins >= 15) {
                    sumCoins -= 15;
                    System.out.println("Purchased Crisps");
                } else {
                    System.out.println("Sorry, not enough money");
                }

            } else if (selectDrink.equals("Soda")) {
                if (sumCoins >= 8) {
                    sumCoins -= 8;
                    System.out.println("Purchased Soda");
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (selectDrink.equals("Coke")) {
                if (sumCoins >= 10) {
                    sumCoins -= 10;
                    System.out.println("Purchased Coke");
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (!selectDrink.equals("Nuts") || !selectDrink.equals("Water") || !selectDrink.equals("Crisps")
                    || !selectDrink.equals("Sida") || !selectDrink.equals("Coke")) {

                System.out.println("Invalid product");
            }
            selectDrink = scan.nextLine();
        }

        System.out.printf("Change: %.2f", sumCoins / 10);


    }
}
