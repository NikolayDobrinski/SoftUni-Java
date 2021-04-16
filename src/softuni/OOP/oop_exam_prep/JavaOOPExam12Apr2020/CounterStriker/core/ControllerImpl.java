package softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.core;

import softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.field.Field;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.field.FieldImpl;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.guns.Gun;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.guns.Pistol;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.guns.Rifle;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.players.CounterTerrorist;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.players.Player;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.players.Terrorist;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.repositories.GunRepository;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.repositories.PlayerRepository;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.repositories.Repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import static softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.common.ExceptionMessages.*;
import static softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.common.OutputMessages.*;

public class ControllerImpl implements Controller{

    private Repository<Gun> gunRepository;
    private Repository<Player> playerRepository;
    private Field field;

    public ControllerImpl() {
        this.gunRepository = new GunRepository();
        this.playerRepository = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name, bulletsCount);
                break;
            case "Rifle":
                gun = new Rifle(name, bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }

        gunRepository.add(gun);

        return String.format(SUCCESSFULLY_ADDED_GUN, gun.getName());
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Gun gun = this.gunRepository.findByName(gunName);
        if (gun == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }

        Player player;
        switch (type) {
            case "Terrorist":
                player = new Terrorist(username, health, armor, gun);
                break;
            case "CounterTerrorist":
                player = new CounterTerrorist(username, health, armor, gun);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        playerRepository.add(player);
        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        Collection<Player> alivePlayers = playerRepository.getModels().stream()
                .filter(p -> p.isAlive()).collect(Collectors.toList());
        return this.field.start(alivePlayers);
    }

    @Override
    public String report() {
        return this.playerRepository.getModels().stream()
                .sorted(Comparator.comparing(Player::getUsername))
                .sorted(Comparator.comparingInt(Player::getHealth).reversed())
                .sorted(Comparator.comparing(f -> f.getClass().getSimpleName()))
                .map(Object::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
