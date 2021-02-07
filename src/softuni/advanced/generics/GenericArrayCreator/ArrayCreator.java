package softuni.advanced.generics.GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator<T> {

    public static <T> T[] create(int lenght, T item) {
        T[] arr = (T[]) Array.newInstance(item.getClass(), lenght);

        Arrays.fill(arr, item);

        return arr;
    }

    public static <T> T[] create(Class<T> clazz, int lenght, T item) {
        T[] arr = (T[]) Array.newInstance(clazz, lenght);

        Arrays.fill(arr, item);

        return arr;
    }

}
