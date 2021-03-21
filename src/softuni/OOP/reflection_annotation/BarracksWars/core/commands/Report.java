package softuni.OOP.reflection_annotation.BarracksWars.core.commands;

import softuni.OOP.reflection_annotation.BarracksWars.interfaces.Repository;
import softuni.OOP.reflection_annotation.BarracksWars.interfaces.UnitFactory;

public class Report extends Command {

    public Report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return getRepository().getStatistics();

    }
}
