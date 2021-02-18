package softuni.advanced.examprep.Christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    private String color;
    private int capacity;
    private List<Present> presents;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.presents = new ArrayList<>();
    }

    public String getColor() {
        return this.color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.presents.size();
    }

    public void add(Present present) {
        if (capacity > presents.size()) {
            presents.add(present);
        }
    }

    public boolean remove(String name) {
        return presents.removeIf(p -> p.getName().equals(name));
    }

    public Present heaviestPresent() {
        Present heaviest = null;
        for (Present p : presents) {
            if (heaviest == null || p.getWeight() > heaviest.getWeight()) {
                heaviest = p;
            }
        }
        return heaviest;
    }

    public Present getPresent(String name) {
        Present present = null;
        for (Present p : presents) {
            if (p.getName().equals(name)) {
                present = p;
            }
        }
        return present;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.color + " bag contains:").append(System.lineSeparator());
        for (Present p : presents) {
            sb.append(p.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
