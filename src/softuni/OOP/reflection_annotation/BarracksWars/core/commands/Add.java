package softuni.OOP.reflection_annotation.BarracksWars.core.commands;

import softuni.OOP.reflection_annotation.BarracksWars.interfaces.Repository;
import softuni.OOP.reflection_annotation.BarracksWars.interfaces.Unit;
import softuni.OOP.reflection_annotation.BarracksWars.interfaces.UnitFactory;

public class Add extends Command {

    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = getUnitFactory().createUnit(unitType);
        getRepository().addUnit(unitToAdd);
        return unitType + " added!";

    }
}
