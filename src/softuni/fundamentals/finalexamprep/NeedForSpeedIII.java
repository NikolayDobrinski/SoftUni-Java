package softuni.fundamentals.finalexamprep;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**Description:
 * You will receive an integer n – the number of cars that you can obtain. On the next n lines the cars themselves
 * will follow with their mileage and fuel available, separated by "|" in the following format: {car}|{mileage}|{fuel}.
 * Then, you will be receiving different commands, each on a new line, separated by " : ", until the "Stop" command is given:
 * Drive : {car} : {distance} : {fuel} ;
 * Refuel : {car} : {fuel};
 * Revert : {car} : {kilometers};
 */

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, int[]> cars = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] car = scan.nextLine().split("\\|");
            String name = car[0];
            int mileage = Integer.parseInt(car[1]);
            int fuel = Integer.parseInt(car[2]);

            int[] currentCar = new int[]{mileage, fuel};

            cars.put(name, currentCar);
        }
        String input = scan.nextLine();

        while (!input.equals("Stop")) {
            String[] command = input.split(" : ");
            String name = command[1];

            switch (command[0]) {
                case "Drive":
                    int distance = Integer.parseInt(command[2]);
                    int fuel = Integer.parseInt(command[3]);

                    if (cars.get(name)[1] - fuel > 0) {
                        cars.get(name)[1] = cars.get(name)[1] - fuel;
                        cars.get(name)[0] = cars.get(name)[0] + distance;
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", name, distance, fuel);
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    if (cars.get(name)[0] > 100000) {
                        System.out.printf("Time to sell the %s!%n", name);
                        cars.remove(name);
                    }
                    break;
                case "Refuel":
                    int fuelRefuel = Integer.parseInt(command[2]);
                    if (cars.get(name)[1] + fuelRefuel > 75) {
                        int refueled = 75 - cars.get(name)[1];
                        cars.get(name)[1] = 75;
                        System.out.printf("%s refueled with %d liters%n", name, refueled);
                    } else {
                        cars.get(name)[1] = cars.get(name)[1] + fuelRefuel;
                        System.out.printf("%s refueled with %d liters%n", name, fuelRefuel);
                    }
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(command[2]);
                    if (cars.get(name)[0] - kilometers > 10000) {
                        cars.get(name)[0] = cars.get(name)[0] - kilometers;
                        System.out.printf("%s mileage decreased by %d kilometers%n", name, kilometers);
                    } else {
                        cars.get(name)[0] = 10000;
                    }

                    break;
            }

            input = scan.nextLine();
        }
        cars.entrySet().stream().sorted((a, b) -> {
            int result = b.getValue()[0] - a.getValue()[0];
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(c -> {
            System.out.println(c.getKey() + " -> Mileage: " + c.getValue()[0] + " kms, Fuel in the tank: " + c.getValue()[1] + " lt.");
        });

    }
}
