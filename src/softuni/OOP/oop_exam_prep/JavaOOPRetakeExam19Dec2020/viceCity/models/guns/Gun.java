package softuni.OOP.oop_exam_prep.JavaOOPRetakeExam19Dec2020.viceCity.models.guns;

public interface Gun {
    String getName();

    int getBulletsPerBarrel();

    boolean canFire();

    int getTotalBullets();

    int fire();
}
