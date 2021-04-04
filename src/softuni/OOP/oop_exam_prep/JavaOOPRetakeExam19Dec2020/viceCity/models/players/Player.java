package softuni.OOP.oop_exam_prep.JavaOOPRetakeExam19Dec2020.viceCity.models.players;

import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam19Dec2020.viceCity.models.guns.Gun;
import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam19Dec2020.viceCity.repositories.interfaces.Repository;

public interface Player {
    String getName();

    int getLifePoints();

    boolean isAlive();

    Repository<Gun> getGunRepository();

    void takeLifePoints(int points);
}
