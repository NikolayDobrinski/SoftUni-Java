package softuni.OOP.reflection_annotation.HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Field[] fields = Reflection.class.getDeclaredFields();
        Arrays.stream(fields)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.printf("%s must be private!%n", f.getName()));

        Method[] getters = Reflection.class.getDeclaredMethods();
        Arrays.stream(getters)
                .filter(f -> f.getName().startsWith("get") && !Modifier.isPublic(f.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(f -> System.out.printf("%s have to be public!%n", f.getName()));

        Method[] setters = Reflection.class.getDeclaredMethods();
        Arrays.stream(getters)
                .filter(f -> f.getName().startsWith("set") && !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(f -> System.out.printf("%s have to be private!%n", f.getName()));
    }
}
