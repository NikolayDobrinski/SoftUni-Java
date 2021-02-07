package softuni.advanced.generics.JarOfT;

/**Description:
 * We have to create a class Jar<> that can store anything.
 * It should have two public methods - add(element) and remove().
 */

public class Main {
    public static void main(String[] args) {

        Jar<Integer> jar = new Jar<>();

        jar.add(13);
    }

    public static void print(Object number) {
        System.out.println(number);
    }
}
