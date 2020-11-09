package softuni.fundamentals.midexamprep;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scan.nextLine());
        int winsCount = 0;

        String command = scan.nextLine();
        while (!command.equals("End of battle")){
            int distanceToEnemy = Integer.parseInt(command);

            if (initialEnergy >= distanceToEnemy && initialEnergy > 0){
                initialEnergy -= distanceToEnemy;
                winsCount++;

                if (winsCount % 3 == 0){
                    initialEnergy +=winsCount;
                }
            }
            else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy",
                        winsCount, initialEnergy);
                return;
            }

            command = scan.nextLine();
        }
        System.out.printf("Won battles: %d. Energy left: %d", winsCount, initialEnergy );

    }
}
