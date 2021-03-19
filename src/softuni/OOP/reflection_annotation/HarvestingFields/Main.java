package softuni.OOP.reflection_annotation.HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Field[] declaredFields = RichSoilLand.class.getDeclaredFields();

        String line = scan.nextLine();

        while (!line.equals("HARVEST")) {
            final String modifier = line;

            Field[] fields = Arrays.stream(declaredFields)
                    .filter(f -> Modifier.toString(f.getModifiers()).equals(modifier))
                    .toArray(Field[]::new);

            if (fields.length == 0) {
                printFields(declaredFields);
            } else {
                printFields(fields);
            }

            line = scan.nextLine();
        }
    }

    public static void printFields(Field[] fields) {
        Arrays.stream(fields).forEach(f -> System.out.printf("%s %s %s%n",
                Modifier.toString(f.getModifiers()),
                f.getType().getSimpleName(),
                f.getName()));
    }
}
