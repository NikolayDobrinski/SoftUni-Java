package softuni.OOP.oop_exam_prep.JavaOOPRetakeExam19Dec2020.viceCity.models.neighbourhood;

import softuni.OOP.oop_exam_prep.JavaOOPRetakeExam19Dec2020.viceCity.models.players.Player;

import java.util.Collection;

public interface Neighbourhood {

    void action(Player mainPlayer, Collection<Player> civilPlayers);
}
