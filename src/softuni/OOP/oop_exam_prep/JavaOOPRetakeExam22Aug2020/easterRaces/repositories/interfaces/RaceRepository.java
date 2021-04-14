package softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.repositories.interfaces;

import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.entities.racers.Race;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RaceRepository implements Repository<Race> {

    Collection<Race> models;

    public RaceRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        return models.stream().filter(r -> r.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Race model) {
        models.add(model);
    }

    @Override
    public boolean remove(Race model) {
        Race race = models.stream().filter(r -> r.getName().equals(model.getName())).findFirst().orElse(null);
        if (race != null) {
            models.remove(race);
            return true;
        }
        return false;
    }
}


