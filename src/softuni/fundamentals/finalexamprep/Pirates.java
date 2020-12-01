package softuni.fundamentals.finalexamprep;

import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String input = scan.nextLine();
        Map<String, List<Integer>> targetCities = new LinkedHashMap<>();

        while (!input.equals("Sail")) {
            String[] currentCity = input.split("\\|+");
            String name = currentCity[0];
            int population = Integer.parseInt(currentCity[1]);
            int gold = Integer.parseInt(currentCity[2]);

            if (targetCities.containsKey(name)) {
                int currentPopulation = targetCities.get(name).get(0);
                targetCities.get(name).set(0, currentPopulation + population);
                int currentGold = targetCities.get(name).get(1);
                targetCities.get(name).set(1, currentGold + gold);
            } else {
                targetCities.put(name, new ArrayList<>());
                targetCities.get(name).add(0, population);
                targetCities.get(name).add(1, gold);
            }

            input = scan.nextLine();
        }

        input = scan.nextLine();

        while (!input.equals("End")) {
            String[] currentCommand = input.split("=>");
            String command = currentCommand[0];
            String town = currentCommand[1];

            switch (command) {
                case "Plunder":
                    int people = Integer.parseInt(currentCommand[2]);
                    int gold = Integer.parseInt(currentCommand[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
                    int currentPeople = targetCities.get(town).get(0) - people;
                    int currentGold = targetCities.get(town).get(1) - gold;
                    targetCities.get(town).set(0, currentPeople);
                    targetCities.get(town).set(1, currentGold);
                    if (currentPeople <= 0 || currentGold <= 0) {
                        targetCities.remove(town);
                        System.out.printf("%s has been wiped off the map!%n", town);
                    }
                    break;
                case "Prosper":
                    int goldToAdd = Integer.parseInt(currentCommand[2]);
                    if (goldToAdd >= 0) {
                        int ownGold = targetCities.get(town).get(1);
                        int totalGold = ownGold + goldToAdd;
                        targetCities.get(town).set(1, totalGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldToAdd, town, totalGold);
                    } else {
                        System.out.println("Gold added cannot be a negative number!");
                    }
                    break;
            }
            input = scan.nextLine();
        }
        if (targetCities.size() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", targetCities.size());
            targetCities.entrySet()
                    .stream()
                    .sorted((a, b) -> {
                        int result = b.getValue().get(1) - a.getValue().get(1);
                        if (result == 0) {
                            result = a.getKey().compareTo(b.getKey());
                        }
                        return result;
                    })
                    .forEach(t -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                            t.getKey(), t.getValue().get(0), t.getValue().get(1)));
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }


    }
}
