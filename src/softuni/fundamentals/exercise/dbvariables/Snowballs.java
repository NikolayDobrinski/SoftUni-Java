package softuni.fundamentals.exercise.dbvariables;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int biggestSbs = 0;
        int biggestSbt = 0;
        int biggestSbq = 0;
        int theBestSnowBall = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int showBallSnow = Integer.parseInt(scan.nextLine());
            int snowBallTime = Integer.parseInt(scan.nextLine());
            int snowBallQuality = Integer.parseInt(scan.nextLine());

            int currentBall = (showBallSnow / snowBallTime);
            int multiplicator = currentBall;

            for (int j = 1; j < snowBallQuality; j++) {
                int result = currentBall * multiplicator;
                currentBall = result;
            }

            if (currentBall > theBestSnowBall) {
                biggestSbs = showBallSnow;
                biggestSbt = snowBallTime;
                biggestSbq = snowBallQuality;
                theBestSnowBall = currentBall;
            }

        }
        System.out.printf("%d : %d = %d (%d)", biggestSbs, biggestSbt, theBestSnowBall, biggestSbq);
    }
}
