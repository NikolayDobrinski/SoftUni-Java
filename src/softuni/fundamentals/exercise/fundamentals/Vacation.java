package softuni.fundamentals.exercise.fundamentals;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scan.nextLine());
        String typeOfGroup = scan.nextLine();
        String dayOfWeek = scan.nextLine();

        double totalSum = 0;

        if (typeOfGroup.equals("Students")) {
            switch (dayOfWeek) {
                case "Friday":
                    totalSum = numberOfPeople * 8.45;
                    break;
                case "Saturday":
                    totalSum = numberOfPeople * 9.80;
                    break;
                case "Sunday":
                    totalSum = numberOfPeople * 10.46;
            }
        } else if (typeOfGroup.equals("Business")) {
            switch (dayOfWeek) {
                case "Friday":
                    totalSum = numberOfPeople * 10.90;
                    break;
                case "Saturday":
                    totalSum = numberOfPeople * 15.60;
                    break;
                case "Sunday":
                    totalSum = numberOfPeople * 16;
            }
        } else if (typeOfGroup.equals("Regular")) {
            switch (dayOfWeek) {
                case "Friday":
                    totalSum = numberOfPeople * 15;
                    break;
                case "Saturday":
                    totalSum = numberOfPeople * 20;
                    break;
                case "Sunday":
                    totalSum = numberOfPeople * 22.50;
            }
        }

        if (typeOfGroup.equals("Students") && numberOfPeople >= 30) {
            totalSum *= 0.85;
        } else if (typeOfGroup.equals("Business") && numberOfPeople >= 100) {
            if (dayOfWeek.equals("Friday")) {
                totalSum -= 10 * 10.90;
            } else if (dayOfWeek.equals("Saturday")) {
                totalSum -= 10 * 15.60;
            } else if (dayOfWeek.equals("Sunday")) {
                totalSum -= 10 * 16;
            }
        } else if (typeOfGroup.equals("Regular") && numberOfPeople >= 10 && numberOfPeople <= 20) {
            totalSum *= 0.95;
        }

        System.out.printf("Total price: %.2f", totalSum);


    }
}
