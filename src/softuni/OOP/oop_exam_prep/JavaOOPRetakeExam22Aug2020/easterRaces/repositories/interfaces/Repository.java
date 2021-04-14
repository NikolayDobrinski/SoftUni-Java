package softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.repositories.interfaces;

import java.util.Collection;

public interface Repository<T> {
    T getByName(String name);

    Collection<T> getAll();

    void add(T model);

    boolean remove(T model);
}
