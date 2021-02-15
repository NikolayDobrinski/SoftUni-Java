package softuni.advanced.examprep.VetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {

    private int capacity;
    private List<Pet> pets;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.pets = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (capacity > this.pets.size()) {
            this.pets.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet p : pets) {
            if (p.getName().equals(name)) {
                pets.remove(p);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        Pet pet = null;
        for (Pet p : pets) {
            if (p.getName().equals(name) && p.getOwner().equals(owner)) {
                pet = p;
            }
        }
        return pet;
    }

    public Pet getOldestPet() {
        Pet pet = null;
        for (Pet p : pets) {
            if (pet == null || pet.getAge() < p.getAge()) {
                pet = p;
            }
        }
        return pet;
    }

    public int getCount() {
        return this.pets.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("The clinic has the following patients:");
        sb.append(System.lineSeparator());

        for (Pet p : pets) {
            sb.append(p.getName() + " " + p.getOwner()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
