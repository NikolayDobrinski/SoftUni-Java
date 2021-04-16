package softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.players;

import softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.guns.Gun;

public class Terrorist extends PlayerImpl{

    public Terrorist(String username, int health, int armor, Gun gun) {
        super(username, health, armor, gun);
    }
}
