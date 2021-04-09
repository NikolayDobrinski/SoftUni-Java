package softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.repositories.interfaces;

public interface TableRepository<T> extends Repository<T> {
    T getByNumber(int number);
}
