package softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.repositories;

import softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.entities.decorations.Decoration;

public interface Repository  {
    void add(Decoration decoration);

    boolean remove(Decoration decoration);

    Decoration findByType(String type);
}
