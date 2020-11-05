package softuni.fundamentals.midexamprep;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int capacity = scan.nextInt() + scan.nextInt() + scan.nextInt();
        int peopleOnQueue = scan.nextInt();
        int counterHours = 0;

        while (peopleOnQueue > 0) {
            counterHours++;

            if (counterHours % 4 != 0) {
                peopleOnQueue -= capacity;
            }

        }
        System.out.printf("Time needed: %dh.", counterHours);

    }
}
