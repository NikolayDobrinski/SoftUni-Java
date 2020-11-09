package softuni.fundamentals.midexamprep;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] targets = Arrays.stream(scan.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();

        String command = scan.nextLine();
        int shotTargetsCount = 0;

        while (!command.equals("End")){
            int index = Integer.parseInt(command);

            if (index >= 0 && index < targets.length){
                shotTargetsCount++;

                for (int i = 0; i < targets.length; i++) {

                    if ( index != i && targets[i] != -1) {

                        if (targets[index] < targets[i]) {
                            targets[i] -= targets[index];
                        } else if (targets[index] >= targets[i]) {
                            targets[i] += targets[index];
                        }

                    }
                }
                targets[index] = -1;
            }

            command = scan.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", shotTargetsCount);
        for (int i = 0; i < targets.length; i++) {
            System.out.print(targets[i] + " ");
        }

    }
}
