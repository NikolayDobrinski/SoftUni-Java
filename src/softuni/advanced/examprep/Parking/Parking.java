package softuni.advanced.examprep.Parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    List<Car> data;

    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    public void add(Car car) {
        this.data.add(car);
    }

    public boolean remove(String manufacturer, String model) {
        for (Car datum : data) {
            if (datum.getManufacturer().equals(manufacturer) && datum.getModel().equals(model)) {
                data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        int year = 0;
        Car latestCar = new Car();

        if (!data.isEmpty()) {
            for (Car car : data) {
                if (car.getYear() > year) {
                    year = car.getYear();
                    latestCar = new Car(car.getManufacturer(), car.getModel(), car.getYear());
                }
            }
            return latestCar;
        }
        return null;
    }

    public Car getCar(String manufacturer, String model) {
        Car newCar = new Car();
        for (Car car1 : data) {
            if (car1.getManufacturer().equals(manufacturer) && car1.getModel().equals(model)) {
                newCar = new Car(car1.getManufacturer(), car1.getModel(), car1.getYear());
                return newCar;
            }
        }
        return null;
    }

    public long getCount() {
        long count = data.stream().count();
        return count;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append("The cars are parked in " + this.type + ":").append(System.lineSeparator());
        for (Car car : data) {
            sb.append(car.toString()).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
