package softuni.fundamentals.more.exercise.Fundamentals;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double onwMoney = Double.parseDouble(scan.nextLine());
        double money = onwMoney;

        String command = scan.nextLine();

        while (!command.equals("Game Time")) {

            String nameOfGame = command;

            if (nameOfGame.equals("OutFall 4")) {
                if (money >= 39.99) {
                    money -= 39.99;
                    System.out.println("Bought OutFall 4");
                } else if (money == 0) {
                    System.out.println("Out of money!");
                    return;
                } else if (money < 39.99) {
                    System.out.println("Too Expensive");
                }
            } else if (nameOfGame.equals("CS: OG")) {
                if (money >= 15.99) {
                    money -= 15.99;
                    System.out.println("Bought CS: OG");
                } else if (money == 0) {
                    System.out.println("Out of money!");
                    return;
                } else if (money < 15.99) {
                    System.out.println("Too Expensive");
                }
            } else if (nameOfGame.equals("Zplinter Zell")) {
                if (money >= 19.99) {
                    money -= 19.99;
                    System.out.println("Bought Zplinter Zell");
                } else if (money == 0) {
                    System.out.println("Out of money!");
                    return;
                } else if (money < 19.99) {
                    System.out.println("Too Expensive");
                }
            } else if (nameOfGame.equals("Honored 2")) {
                if (money >= 59.99) {
                    money -= 59.99;
                    System.out.println("Bought Honored 2");
                } else if (money == 0) {
                    System.out.println("Out of money!");
                    return;
                } else if (money < 59.99) {
                    System.out.println("Too Expensive");
                }
            } else if (nameOfGame.equals("RoverWatch")) {
                if (money >= 29.99) {
                    money -= 29.99;
                    System.out.println("Bought RoverWatch");
                } else if (money == 0) {
                    System.out.println("Out of money!");
                    return;
                } else if (money < 29.99) {
                    System.out.println("Too Expensive");
                }
            } else if (nameOfGame.equals("RoverWatch Origins Edition")) {
                if (money >= 39.99) {
                    money -= 39.99;
                    System.out.println("Bought RoverWatch Origins Edition");
                } else if (money == 0) {
                    System.out.println("Out of money!");
                    return;
                } else if (money < 39.99) {
                    System.out.println("Too Expensive");
                }
            } else if (!nameOfGame.equals("OutFall 4") && !nameOfGame.equals("CS: OG") && !nameOfGame.equals("Zplinter Zell")
                    && !nameOfGame.equals("Honored 2") && !nameOfGame.equals("RoverWatch")
                    && !nameOfGame.equals("RoverWatch Origins Edition")) {
                System.out.println("Not Found");
            }

            command = scan.nextLine();
        }
        double totalSpent = onwMoney - money;
        System.out.printf("Total spent: $%.2f. ", totalSpent);
        double moneyLeft = onwMoney - totalSpent;
        System.out.printf("Remaining: $%.2f", moneyLeft);

    }
}
