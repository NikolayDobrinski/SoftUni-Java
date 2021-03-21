package softuni.OOP.reflection_annotation.BarracksWars.core.commands;

import softuni.OOP.reflection_annotation.BarracksWars.interfaces.Executable;
import softuni.OOP.reflection_annotation.BarracksWars.interfaces.Repository;
import softuni.OOP.reflection_annotation.BarracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {

    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected String[] getData() {
        return data;
    }

    protected Repository getRepository() {
        return repository;
    }

    protected UnitFactory getUnitFactory() {
        return unitFactory;
    }
}
