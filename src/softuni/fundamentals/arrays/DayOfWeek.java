package softuni.fundamentals.arrays;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        int day = Integer.parseInt(scan.nextLine());

        if (1 <= day && day <= 7) {
            System.out.println(weekDays[day - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
