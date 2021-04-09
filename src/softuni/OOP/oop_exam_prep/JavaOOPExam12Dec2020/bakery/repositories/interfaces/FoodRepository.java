package softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.repositories.interfaces;

public interface FoodRepository<T> extends Repository<T> {
    T getByName(String name);
}
