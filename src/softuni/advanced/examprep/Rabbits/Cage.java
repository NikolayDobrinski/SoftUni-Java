package softuni.advanced.examprep.Rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {

    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (capacity > this.data.size()) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        return this.data.removeIf(rabbit -> rabbit.getName().equals(name));
    }

    public void removeSpecies(String species) {
        for (Rabbit r : this.data) {
            if (r.getSpecies().equals(species)) {
                this.data.remove(r);
            }
        }
    }

    public Rabbit sellRabbit(String name) {
        Rabbit sellRabbit = null;
        for (Rabbit r : this.data) {
            if (r.getName().equals(name)) {
                r.setAvailable(false);
                sellRabbit = r;
            }
        }
        return sellRabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> sellBySpecies = new ArrayList<>();
        for (Rabbit r : this.data) {
            if (r.getSpecies().equals(species)) {
                sellBySpecies.add(r);
                r.setAvailable(false);
            }
        }
        if (sellBySpecies.isEmpty()) {
            return null;
        }
        return sellBySpecies;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder out = new StringBuilder("Rabbits available at " + this.name + ":")
                .append(System.lineSeparator());

        for (Rabbit r : this.data) {
            if (r.isAvailable()) {
                out.append(r.toString()).append(System.lineSeparator());
            }
        }
        return out.toString().trim();
    }
}
