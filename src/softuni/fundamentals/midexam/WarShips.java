package softuni.fundamentals.midexam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WarShips {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        List<Integer> pirateShipSection = Arrays.stream(scan.nextLine().split(">")).
                map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> warShipSection = Arrays.stream(scan.nextLine().split(">")).
                map(Integer::parseInt).collect(Collectors.toList());

        int maxHealthCapacity = Integer.parseInt(scan.nextLine());

        String command = scan.nextLine();

        while (!command.equals("Retire")){
            String [] line = command.split(" ");
            String currentCommand = line[0];

            if (currentCommand.equals("Fire")){
                int index = Integer.parseInt(line[1]);
                int damage = Integer.parseInt(line[2]);
                if (index >= 0 && index < warShipSection.size()){
                    int currentValue = warShipSection.get(index);
                    if (currentValue - damage <= 0){
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    }
                    else {
                        warShipSection.set(index, currentValue - damage);
                    }
                }
            }
            else if (currentCommand.equals("Defend")){
                int startIndex = Integer.parseInt(line[1]);
                int endIndex = Integer.parseInt(line[2]);
                int damage = Integer.parseInt(line[3]);

                if (startIndex >= 0 && startIndex < pirateShipSection.size() &&
                       endIndex >=0 && endIndex < pirateShipSection.size()){

                    for (int i = startIndex; i <= endIndex ; i++) {
                        if (pirateShipSection.get(i) - damage <= 0){
                            System.out.println("You lost! The pirate ship has sunken.");
                            return;
                        }
                        else {
                            int currentValue = pirateShipSection.get(i);
                            pirateShipSection.set(i, currentValue - damage);
                        }
                    }
                }
                else {
                    break;
                }
            }
            else if (currentCommand.equals("Repair")){
                int index = Integer.parseInt(line[1]);
                int health = Integer.parseInt(line[2]);

                if (index >= 0 && index < pirateShipSection.size()) {
                    int currentValue = pirateShipSection.get(index);
                    pirateShipSection.set(index, currentValue + health);

                    if (pirateShipSection.get(index) > maxHealthCapacity) {
                        pirateShipSection.set(index, maxHealthCapacity);
                    }
                }
                else {
                    break;
                }
            }
            else if (currentCommand.equals("Status")){
                int statusLimit = (int) (Math.round(maxHealthCapacity * 0.2));
                int sectionsToBeRepairedCount = 0;
                for (int i = 0; i < pirateShipSection.size(); i++) {
                    if (pirateShipSection.get(i)  < statusLimit){
                        sectionsToBeRepairedCount++;
                    }
                }
                System.out.printf("%d sections need repair.%n", sectionsToBeRepairedCount);
            }

            command = scan.nextLine();
        }

        int pirateShipStatus = 0;
        for (int i = 0; i < pirateShipSection.size() ; i++) {
            pirateShipStatus += pirateShipSection.get(i);
        }
        int warShipStatus = 0;
        for (int i = 0; i < warShipSection.size() ; i++) {
            warShipStatus += warShipSection.get(i);
        }

        System.out.printf("Pirate ship status: %d%n", pirateShipStatus);
        System.out.printf("Warship status: %d", warShipStatus);
    }
}
