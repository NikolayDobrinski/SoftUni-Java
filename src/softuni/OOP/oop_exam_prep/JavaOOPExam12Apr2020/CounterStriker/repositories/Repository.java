package softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.repositories;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getModels();

    void add(T model);

    boolean remove(T model);

    T findByName(String name);
}
