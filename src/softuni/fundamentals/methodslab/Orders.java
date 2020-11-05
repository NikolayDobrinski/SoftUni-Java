package softuni.fundamentals.methodslab;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String order = scan.nextLine();
        int quantity = Integer.parseInt(scan.nextLine());

        countTotalOrderandPrint(order, quantity);

    }

    private static void countTotalOrderandPrint(String order, int quantity) {
        switch (order) {
            case "coffee":
                double coffee = 1.50 * quantity;
                System.out.printf("%.2f", coffee);
                break;
            case "water":
                double water = 1.00 * quantity;
                System.out.printf("%.2f", water);
                break;
            case "coke":
                double coke = 1.40 * quantity;
                System.out.printf("%.2f", coke);
                break;
            case "snacks":
                double snacks = 2.00 * quantity;
                System.out.printf("%.2f", snacks);
                break;
        }
    }
}
