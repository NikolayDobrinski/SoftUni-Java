package softuni.fundamentals.objectsandclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VehicleCatalogue {
    static class Vehicle {
        String type;
        String model;
        String color;
        int horsepower;

        public Vehicle(String type, String model, String color, int horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String getType() {
            return type;
        }

        public String getColor() {
            return color;
        }

        public String getModel() {
            return model;
        }

        public int getHorsepower() {
            return horsepower;
        }

        public String toString() {
            return String.format("Type: %s%n" + "Model: %s%n" + "Color: %s%n" + "Horsepower: %d",
                    getType().toUpperCase().charAt(0) + getType().substring(1),
                    getModel(), getColor(), getHorsepower());


        }
    }

    public static double averageHorsepower(List<Vehicle> vehicles) {
        if (vehicles.size() == 0) {
            return 0.0;
        } else {
            return vehicles.stream().mapToDouble(Vehicle::getHorsepower).sum() / vehicles.size();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Vehicle> allVehicles = new ArrayList<>();

        String input = scan.nextLine();

        while (!input.equals("End")) {

            String[] currentVehicle = input.split(" ");

            String type = currentVehicle[0];
            String model = currentVehicle[1];
            String color = currentVehicle[2];
            int horsepower = Integer.parseInt(currentVehicle[3]);

            Vehicle vehicle = new Vehicle(type, model, color, horsepower);

            allVehicles.add(vehicle);
            input = scan.nextLine();
        }

        String line = scan.nextLine();

        while (!line.equals("Close the Catalogue")) {

            String model = line;

            allVehicles.stream().filter(vehicle -> vehicle.getModel().equals(model)).
                    forEach(vehicle -> System.out.println(vehicle.toString()));


            line = scan.nextLine();
        }
        List<Vehicle> cars = allVehicles.stream().filter(vehicle -> vehicle.getType().
                equals("car")).collect(Collectors.toList());

        List<Vehicle> trucks = allVehicles.stream().filter(vehicle -> vehicle.getType().
                equals("truck")).collect(Collectors.toList());

        System.out.printf("Cars have average horsepower of: %.2f.%n", averageHorsepower(cars));
        System.out.printf("Trucks have average horsepower of: %.2f.", averageHorsepower(trucks));

    }
}

