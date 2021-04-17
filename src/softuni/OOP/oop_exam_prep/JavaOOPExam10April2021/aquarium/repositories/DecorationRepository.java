package softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.repositories;

import softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.entities.decorations.Decoration;

import java.util.ArrayList;
import java.util.Collection;

public class DecorationRepository implements softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.repositories.Repository {

    private Collection<Decoration> decorations;

    public DecorationRepository() {
        this.decorations = new ArrayList<>();
    }

    @Override
    public void add(Decoration decoration) {
    this.decorations.add(decoration);
    }

    @Override
    public boolean remove(Decoration decoration) {
        return this.decorations.remove(decoration);
    }

    @Override
    public Decoration findByType(String type) {
        Decoration decoration = this.decorations.stream().filter(d ->
                d.getClass().getSimpleName().equals(type)).findFirst().orElse(null);

        return decoration;
    }
}
