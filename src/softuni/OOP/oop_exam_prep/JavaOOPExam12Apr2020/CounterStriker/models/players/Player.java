package softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.players;

import softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.guns.Gun;

public interface Player {
    String getUsername();

    int getHealth();

    int getArmor();

    Gun getGun();

    boolean isAlive();

    void takeDamage(int points);
}
