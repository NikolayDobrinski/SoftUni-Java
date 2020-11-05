package softuni.fundamentals.easy;

import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String typeOfDay = scan.nextLine();
        int ageOfCustomer = Integer.parseInt(scan.nextLine());
        int totalPrice = 0;

        if (ageOfCustomer <= 18) {
            if (typeOfDay.equals("Weekday")) {
                totalPrice += 12;
            } else if (typeOfDay.equals("Weekend")) {
                totalPrice += 15;
            } else if (typeOfDay.equals("Holiday")) {
                totalPrice += 5;
            }
        } else if (ageOfCustomer <= 64) {
            if (typeOfDay.equals("Weekday")) {
                totalPrice += 18;
            } else if (typeOfDay.equals("Weekend")) {
                totalPrice += 20;
            } else if (typeOfDay.equals("Holiday")) {
                totalPrice += 12;
            }
        } else if (ageOfCustomer <= 122) {
            if (typeOfDay.equals("Weekday")) {
                totalPrice += 12;
            } else if (typeOfDay.equals("Weekend")) {
                totalPrice += 15;
            } else if (typeOfDay.equals("Holiday")) {
                totalPrice += 10;
            }
        }

        if (ageOfCustomer < 0 || ageOfCustomer > 122) {
            System.out.print("Error!");
        } else {
            System.out.printf("%d$", totalPrice);
        }


    }
}
