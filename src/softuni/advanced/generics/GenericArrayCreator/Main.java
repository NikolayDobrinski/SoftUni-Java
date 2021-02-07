package softuni.advanced.generics.GenericArrayCreator;

/**Description:
 * We have to create a class with a method and a single overload to it:
 * static T[] create(int length, T item)
 * static T[] create(Class<T> class, int length, T item)
 */

public class Main {
    public static void main(String[] args) {


        Integer[] array = ArrayCreator.create(13,13);

        String[] strings = ArrayCreator.create(String.class, 13, "Java");

        for (Integer integer: array) {
            System.out.println(integer);
        }
    }
}
