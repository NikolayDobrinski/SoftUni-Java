package softuni.fundamentals.midexamprep;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        double sumWithoutTax = 0;

        while ((!input.equals("special") && !input.equals("regular"))) {
            double currentPart = Double.parseDouble(input);
            if (currentPart > 0) {
                sumWithoutTax += currentPart;
            } else {
                System.out.println("Invalid price!");
            }

            input = scan.nextLine();
        }
        double tax = (sumWithoutTax * 1.2) - sumWithoutTax;
        double totalSum = sumWithoutTax + tax;

        if (sumWithoutTax == 0) {
            System.out.println("Invalid order!");
        } else if (input.equals("special")) {
            double totalSumWithDiscount = totalSum * 0.9;
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", sumWithoutTax);
            System.out.printf("Taxes: %.2f$%n", tax);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", totalSumWithDiscount);
        } else if (input.equals("regular")) {

            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", sumWithoutTax);
            System.out.printf("Taxes: %.2f$%n", tax);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", totalSum);
        }

    }
}
