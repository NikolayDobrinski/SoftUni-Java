package softuni.advanced.Exam_20Feb.Dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car c : this.data) {
            if (c.getManufacturer().equals(manufacturer) && c.getModel().equals(model)) {
                this.data.remove(c);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car car = null;
        for (Car c : this.data) {
            if (car == null || car.getYear() < c.getYear()) {
                car = c;
            }
        }
        return car;
    }

    public Car getCar(String manufacturer, String model) {
        Car car = null;
        for (Car c : this.data) {
            if (c.getManufacturer().equals(manufacturer) && c.getModel().equals(model)) {
                car = c;
            }
        }
        return car;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder(" The cars are in a car dealership " + this.name + ":")
                .append(System.lineSeparator());

        for (Car car : this.data) {
            sb.append(car.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
