package softuni.OOP.reflection_annotation.BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

/** Description:
 * We are given a class with all private members. Our tasks are to instantiate an object from this class
 * (always with start value 0) and then invoke the different methods it has. Our restriction is to not change
 * anything in the class itself (consider it a black box). We can look at the class but don't touch anything!
 */

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scan = new Scanner(System.in);

        Constructor<BlackBoxInt> ctor = BlackBoxInt.class.getDeclaredConstructor();
        ctor.setAccessible(true);
        BlackBoxInt blackBoxInt = ctor.newInstance();

        Method[] methods = blackBoxInt.getClass().getDeclaredMethods();
        Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);


        String line;

        while (!"END".equals(line = scan.nextLine())) {

            String[] tokens = line.split("_");
            String command = tokens[0];
            int param = Integer.parseInt(tokens[1]);

            Method method = Arrays.stream(methods).filter(m -> m.getName().equals(command)).findFirst().get();
            method.setAccessible(true);
            method.invoke(blackBoxInt, param);

            System.out.println(innerValue.getInt(blackBoxInt));

        }
    }
}
