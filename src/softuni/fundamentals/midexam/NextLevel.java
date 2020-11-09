package softuni.fundamentals.midexam;

import java.util.Scanner;

public class NextLevel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double amountOfExperience = Double.parseDouble(scan.nextLine());
        int countOfBattles = Integer.parseInt(scan.nextLine());

        boolean success = false;
        int countBattlesToSuccess = 0;
        double experienceGained = 0;

        for (int i = 1; i <= countOfBattles; i++) {
            double currentExperience = Double.parseDouble(scan.nextLine());
            countBattlesToSuccess++;
            if (i > 1 && i % 3 == 0){
                currentExperience *= 1.15;
            }
            else if (i > 1 && i % 5 == 0){
                currentExperience *= 0.9;
            }
            else if (i > 1 && i % 15 == 0){
                currentExperience *= 1.05;
            }

            experienceGained += currentExperience;

            if (experienceGained >= amountOfExperience){
                success = true;
                break;
            }

        }

        if (success){
            System.out.printf("Player successfully collected his needed experience for %d battles.", countBattlesToSuccess);
        }
        else {
            double neededExperience = amountOfExperience - experienceGained;
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", neededExperience);
        }

    }
}
