package softuni.OOP.reflection_annotation.BarracksWars.core.factories;

import softuni.OOP.reflection_annotation.BarracksWars.interfaces.Unit;
import softuni.OOP.reflection_annotation.BarracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        Unit unit = null;

        try {
            Class<?> clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
            unit = (Unit) clazz.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException
                | IllegalAccessException e) {
            e.printStackTrace();
        }

        return unit;
    }
}
