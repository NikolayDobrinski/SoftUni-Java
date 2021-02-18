package softuni.advanced.examprep.Christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return this.color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (capacity > data.size()) {
            data.add(present);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }

    public Present heaviestPresent() {
        Present heaviest = null;
        for (Present p : data) {
            if (heaviest == null || p.getWeight() > heaviest.getWeight()) {
                heaviest = p;
            }
        }
        return heaviest;
    }

    public Present getPresent(String name) {
        Present present = null;
        for (Present p : data) {
            if (p.getName().equals(name)) {
                present = p;
            }
        }
        return present;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.color + " bag contains:").append(System.lineSeparator());
        for (Present p : data) {
            sb.append(p.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
