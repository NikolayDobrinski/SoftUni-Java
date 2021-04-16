package softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.guns;

import static softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.common.ExceptionMessages.*;

public abstract class GunImpl implements Gun{

    private String name;
    private int bulletsCount;

    protected GunImpl(String name, int bulletsCount) {
        this.setName(name);
        this.setBulletsCount(bulletsCount);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(INVALID_GUN_NAME);
        }
        this.name = name;
    }

    public void setBulletsCount(int bulletsCount) {
        if (bulletsCount < 0) {
            throw new IllegalArgumentException(INVALID_GUN_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }
}
