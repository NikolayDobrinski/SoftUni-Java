package softuni.OOP.polymorphism.Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] carInfo = scan.nextLine().split("\\s+");
        String[] truckInfo = scan.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            switch (tokens[0]) {
                case "Drive":
                    double distance = Double.parseDouble(tokens[2]);
                    if (tokens[1].equals("Car")) {
                        System.out.println(car.drive(distance));
                    } else {
                        System.out.println(truck.drive(distance));
                    }
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(tokens[2]);
                    if (tokens[1].equals("Car")) {
                        car.refuel(liters);
                    } else {
                        truck.refuel(liters);
                    }
                    break;
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
