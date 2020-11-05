package softuni.fundamentals.arrays;

import java.util.Scanner;

public class HomExersice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        int day = Integer.parseInt(scan.nextLine());

        if (0 <= day && day <= 6) {
            System.out.println(weekDays[day]);
        } else {
            System.out.println("Invalid day!");
        }


    }
}
