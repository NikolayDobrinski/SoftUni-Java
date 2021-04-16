package softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.repositories;

import softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.common.ExceptionMessages.*;

public class PlayerRepository implements Repository<Player>{

    private Collection<Player> models;

    public PlayerRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Player> getModels() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Player player) {
        if (player == null) {
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
        }
        this.models.add(player);
    }

    @Override
    public boolean remove(Player player) {
        return models.removeIf(m -> m.getUsername().equals(player));
    }

    @Override
    public Player findByName(String player) {
        Player playerToFind = models.stream().filter(m -> m.getUsername().equals(player)).findFirst().orElse(null);
        return playerToFind;
    }
}
