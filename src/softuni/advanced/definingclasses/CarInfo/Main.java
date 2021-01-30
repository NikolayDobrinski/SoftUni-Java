package softuni.advanced.definingclasses.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**Description:
 * We need to create a Car class with fields in it. From the input we get the number of cars that we
 * need to create as objects of this class and print the information about them using a method.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");

            String brand = tokens[0];
            String model = tokens[1];
            int horsePower = Integer.parseInt(tokens[2]);

            Car newCar = new Car(brand, model, horsePower);

            cars.add(newCar);
        }

        for (Car car: cars) {
            car.carInfo();
        }


    }
}
