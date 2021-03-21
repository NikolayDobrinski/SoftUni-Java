package softuni.OOP.reflection_annotation.BarracksWars.core.commands;

import softuni.OOP.reflection_annotation.BarracksWars.interfaces.Repository;
import softuni.OOP.reflection_annotation.BarracksWars.interfaces.UnitFactory;

public class Retire extends Command {

    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        getRepository().removeUnit(unitType);
        return unitType + " retired!";
    }
}
