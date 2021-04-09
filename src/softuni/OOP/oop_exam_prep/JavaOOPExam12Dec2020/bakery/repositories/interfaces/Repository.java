package softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.repositories.interfaces;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> getAll();

    void add(T t);

}
