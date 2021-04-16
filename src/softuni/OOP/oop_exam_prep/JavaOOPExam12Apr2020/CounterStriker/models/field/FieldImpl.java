package softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.field;

import softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.guns.Gun;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FieldImpl implements Field{


    @Override
    public String start(Collection<Player> players) {
        List<Player> terrorist = players.stream()
                .filter(p -> p.getClass().getSimpleName().equals("Terrorist"))
                .collect(Collectors.toList());

        List<Player> counterTerrorist = players.stream()
                .filter(p -> p.getClass().getSimpleName().equals("CounterTerrorist"))
                .collect(Collectors.toList());

        boolean fight = true;
        boolean terroristWin = false;
        while (fight) {

            for (int i = 0; i < terrorist.size(); i++) {
                if (terrorist.get(i).isAlive()) {
                    Gun gun = terrorist.get(i).getGun();

                    for (int j = 0; j < counterTerrorist.size(); j++) {
                        counterTerrorist.get(j).takeDamage(gun.fire());
                    }
                }
            }

            for (int i = 0; i < counterTerrorist.size(); i++) {
                if (counterTerrorist.get(i).isAlive()) {
                    Gun gun = counterTerrorist.get(i).getGun();

                    for (int j = 0; j < terrorist.size(); j++) {
                        terrorist.get(j).takeDamage(gun.fire());
                    }
                }
            }

            if (terrorist.stream().allMatch(t -> !t.isAlive())) {
                fight = false;
            }

            if (counterTerrorist.stream().allMatch(t -> !t.isAlive())) {
                fight = false;
                terroristWin = true;
            }
        }

        if (terroristWin) {
            return String.format("Terrorist wins!");
        }
        else {
            return String.format("Counter Terrorist wins!");
        }
    }
}
