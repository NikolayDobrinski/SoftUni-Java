package softuni.fundamentals.midexamprep;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scan.nextLine());
        int numberOfLectures = Integer.parseInt(scan.nextLine());
        int additionalBonus = Integer.parseInt(scan.nextLine());

        double maxBonus = 0;
        int lectures = 0;

        for (int i = 0; i < numberOfStudents; i++) {
            int attendance = Integer.parseInt(scan.nextLine());

            double totalBonus = attendance * 1.0 / numberOfLectures * (5 + additionalBonus);

            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                lectures = attendance;
            }
        }


        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.", lectures);

    }
}
