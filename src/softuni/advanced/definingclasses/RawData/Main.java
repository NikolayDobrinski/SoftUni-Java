package softuni.advanced.definingclasses.RawData;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**Description:
 * We have to write a program that is tracking the cars and the cargo of courier company.
 * We have to define a class Car that holds information about model, engine, cargo and a collection of exactly 4 tires.
 * The engine, cargo and tire should be separate classes, create a constructor that receives all information about the Car
 * and creates and initializes its inner components (engine, cargo and tires).
 * On the first line of the input we will receive a number N - the number of cars you have,
 * on each of the next N lines you will receive information about a car.
 * After the N lines we will receive a single line with one of 2 commands "fragile" or "flamable" ,
 * if the command is "fragile" print all cars whose Cargo Type is "fragile" with a tire whose pressure is  < 1,
 * if the command is "flamable" print all cars whose Cargo Type is "flamable" and have Engine Power > 250.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            String model = tokens[0];

            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];

            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Tire[] tiers = new Tire[4];
            int count = 0;
            for (int j = 5; j < tokens.length; j += 2) {
                double tierPressure = Double.parseDouble(tokens[j]);
                int tierAge = Integer.parseInt(tokens[j + 1]);
                tiers[count] = new Tire(tierPressure, tierAge);
                count++;
            }

            Car car = new Car(model, engine, cargo, tiers);
            cars.putIfAbsent(model, car);
        }

        String cargoType = scan.nextLine();
        for (Car car : cars.values()) {
            if ("flamable".equals(cargoType)
                    && "flamable".equals(car.getCargo().getCargoType())
                    && car.getEngine().getEnginePower() > 250) {
                System.out.println(car);
            } else if ("fragile".equals(cargoType)
                    && "fragile".equals(car.getCargo().getCargoType())
                    && car.hasTierWithLessPressureThanOne()) {
                System.out.println(car);
            }
        }


    }
}
