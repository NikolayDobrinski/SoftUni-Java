package softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.entities.aquariums;

import softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.entities.decorations.Decoration;
import softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.common.ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY;

public abstract class BaseAquarium implements softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.entities.aquariums.Aquarium {

    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size() == this.capacity) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.fish.stream().forEach(f -> f.eat());

    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder(String.format("%s (%s):", this.getName(), this.getClass().getSimpleName()));
        sb.append(System.lineSeparator());

        if (this.fish.isEmpty()) {
            sb.append("Fish: none");
        } else {
            sb.append("Fish:");
            for (Fish f : fish) {
                sb.append(" ").append(f.getName());
            }
        }
        sb.append(System.lineSeparator());
        sb.append("Decorations: ").append(decorations.size()).append(System.lineSeparator());
        sb.append("Comfort: " + this.calculateComfort());


        return sb.toString().trim();
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}
