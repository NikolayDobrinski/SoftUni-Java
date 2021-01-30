package softuni.advanced.definingclasses.CarConstructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**Description:
 * We have to make proper constructors for the Car class so we can create car objects with different type of input information.
 * We should be able to handle different types of input because some of the data may be missing.
 * For an example we can get only the car brand – which means we have to set the car model to "unknown"
 * and the Horsepower value to -1. There will be lines with complete car data, declare constructor which sets all the fields.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");

            if (tokens.length == 1) {
                Car newCar = new Car(tokens[0]);
                cars.add(newCar);
            } else {
                Car newCar = new Car(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
                cars.add(newCar);
            }
        }

        for (Car car : cars) {
            car.carInfo();
        }
    }
}
