package softuni.advanced.definingclasses.CarSalesman;

import java.util.*;

/**Description:
 * We have to define two classes Car and Engine. A Car has a model, engine, weight and color. An Engine has model,
 * power, displacement and efficiency. A Car's weight and color and its Engine's displacements and efficiency are optional.
 * On the first line, we will read a number N which will specify how many lines of engines we will receive,
 * on each of the next N lines we will receive information about an Engine. After the lines with engines,
 * on the next line we will receive a number M – specifying the number of Cars that will follow,
 * on each of the next M lines the information about a Car will follow in the following format
 * "<Model> <Engine> <Weight> <Color>", where the engine in the format will be the model of an existing Engine.
 * When creating the object for a Car, we should keep a reference to the real engine in it, instead of just the
 * engines model, note that the optional properties might be missing from the formats.
 * Our task is to print each car (in the order you received them) and its information in the format defined bellow.
 * If any of the optional fields has not been given we have to print "n/a".
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Engine> engineMap = new HashMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            Engine engine = null;
            if (tokens.length == 4) {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else if (tokens.length == 2) {
                engine = new Engine(model, power);
            } else if (tokens.length == 3) {
                if (tokens[2].matches("^\\d+$")) {
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                } else {
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                }
            }
            engineMap.putIfAbsent(model, engine);
        }

        List<Car> cars = new LinkedList<>();
        int m = Integer.parseInt(scan.nextLine());
        //FordFocus V4-33 1300 Silver

        for (int i = 0; i < m; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String model = tokens[0];
            Engine engine = engineMap.get(tokens[1]);
            Car car = null;
            if (tokens.length == 4) {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(model, engine, weight, color);
            } else if (tokens.length == 2) {
                car = new Car(model, engine);
            } else if (tokens.length == 3) {
                if (tokens[2].matches("^\\d+$")) {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engine, weight);
                } else {
                    String color = tokens[2];
                    car = new Car(model, engine, color);
                }
            }
            cars.add(car);
        }

        cars.forEach(c -> System.out.println(c));

    }
}
