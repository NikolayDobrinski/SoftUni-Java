package softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.guns;

public class Pistol extends GunImpl{

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    //Pistol can fire() 1 bullet at a time.

    @Override
    public int fire() {
        if (super.getBulletsCount() < 1) {
            return 0;
        }
        super.setBulletsCount(getBulletsCount() - 1);
        return 1;
    }
}
