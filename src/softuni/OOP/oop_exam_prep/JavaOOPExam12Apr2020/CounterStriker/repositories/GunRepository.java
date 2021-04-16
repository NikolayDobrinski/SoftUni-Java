package softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.repositories;

import softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;

import static softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.common.ExceptionMessages.*;

public class GunRepository implements Repository<Gun>{

    private Collection<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return null;
    }

    @Override
    public void add(Gun model) {
        if (model == null) {
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
        this.models.add(model);

    }

    @Override
    public boolean remove(Gun model) {
        boolean gunToRemove = this.models.remove(model);
        return gunToRemove;
    }

    @Override
    public Gun findByName(String name) {
        Gun gun = models.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
        return gun;
    }
}
