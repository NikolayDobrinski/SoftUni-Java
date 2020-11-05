package softuni.fundamentals.easy;

import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

        int totalMinutes = ((hours * 60) + minutes) + 30;

        int finalMinutes = totalMinutes % 60;
        int finalHours = totalMinutes / 60;

        if (finalMinutes < 10 && finalHours < 24) {
            System.out.printf("%d:0%d", finalHours, finalMinutes);
        } else if (finalMinutes < 10 && finalHours > 23) {
            System.out.printf("0:0%d", finalMinutes);

        } else if (finalMinutes >= 10 && finalHours < 24) {
            System.out.printf("%d:%d", finalHours, finalMinutes);
        } else if (finalMinutes >= 10 && finalHours > 23) {
            System.out.printf("0:%d", finalMinutes);
        }


    }
}
