package softuni.OOP.reflection_annotation.BarracksWars;

import softuni.OOP.reflection_annotation.BarracksWars.interfaces.Repository;
import softuni.OOP.reflection_annotation.BarracksWars.interfaces.Runnable;
import softuni.OOP.reflection_annotation.BarracksWars.interfaces.UnitFactory;
import softuni.OOP.reflection_annotation.BarracksWars.core.Engine;
import softuni.OOP.reflection_annotation.BarracksWars.core.factories.UnitFactoryImpl;
import softuni.OOP.reflection_annotation.BarracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
