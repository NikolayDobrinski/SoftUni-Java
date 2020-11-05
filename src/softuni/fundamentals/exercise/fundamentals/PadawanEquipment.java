package softuni.fundamentals.exercise.fundamentals;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double ownMoney = Double.parseDouble(scan.nextLine());
        int numberOfStudents = Integer.parseInt(scan.nextLine());

        double priceSebre = Double.parseDouble(scan.nextLine());
        double priceRobe = Double.parseDouble(scan.nextLine());
        double priceBelt = Double.parseDouble(scan.nextLine());

        double totalPrice = 0;

        double sebresNeeded = Math.ceil((numberOfStudents * 1.1)) * priceSebre;
        double robesNeeded = numberOfStudents * priceRobe;


        if (numberOfStudents >= 6) {
            int discountedBlets = numberOfStudents / 6;
            numberOfStudents -= discountedBlets;
        }

        double beltsNeeded = numberOfStudents * priceBelt;
        totalPrice = sebresNeeded + robesNeeded + beltsNeeded;

        if (ownMoney >= totalPrice) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            double neededMoney = totalPrice - ownMoney;
            System.out.printf("Ivan Cho will need %.2flv more.", neededMoney);
        }


    }

}
