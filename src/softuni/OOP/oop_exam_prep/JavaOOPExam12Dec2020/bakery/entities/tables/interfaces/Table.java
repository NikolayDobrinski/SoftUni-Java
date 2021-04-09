package softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.tables.interfaces;

import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.bakedFoods.interfaces.BakedFood;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.drinks.interfaces.Drink;

public interface Table {
    int getTableNumber();

    int getCapacity();

    int getNumberOfPeople();

    double getPricePerPerson();

    boolean isReserved();

    double getPrice();

    void reserve(int numberOfPeople);

    void orderFood(BakedFood food);

    void orderDrink(Drink drink);

    double getBill();

    void clear();

    String getFreeTableInfo();
}
