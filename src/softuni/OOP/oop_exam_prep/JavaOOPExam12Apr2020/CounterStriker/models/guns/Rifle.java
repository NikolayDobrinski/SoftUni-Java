package softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.guns;

public class Rifle extends GunImpl{

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    //Rifle can fire() 10 bullets at a time.

    @Override
    public int fire() {
        if (super.getBulletsCount() < 10) {
            return 0;
        }
        super.setBulletsCount(getBulletsCount() - 10);
        return 10;
    }
}
