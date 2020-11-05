package softuni.fundamentals.arrays.exercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DoubleCola {
    public static String WhoIsNext(String[] names, int n) {
        int count = 0;
        List<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(names));
        String result;
        while (true) {
            String name = queue.remove(0);
            result = name;
            count++;
            if (count == n) {
                break;
            }
            queue.add(name);
            queue.add(name);
        }
        return result;
    }
}

