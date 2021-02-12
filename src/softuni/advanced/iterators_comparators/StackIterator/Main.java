package softuni.advanced.iterators_comparators.StackIterator;

import java.util.Scanner;

/** Description:
 * We have to create custom stack with two functions - to push an element and to pop it.
 * Then write out custom implementation of Stack<Integer> and implement our custom iterator.
 * Our Stack class should implement the "Iterable<Integer>" interface and out Iterator Class
 * should implement "Iterator<Integer>" interface. Our Custom Iterator should follow the rules
 * of the Abstract Data Type - Stack.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        CustomStack customStack = new CustomStack();
        String[] initialValues = scan.nextLine().split(",\\s+");

        customStack.push(Integer.parseInt(initialValues[0].split("\\s+")[1]));

        for (int i = 1; i < initialValues.length; i++) {
            customStack.push(Integer.parseInt(initialValues[i].trim()));
        }

        String line = "";

        while (!"END".equals(line = scan.nextLine())) {
            if (line.equals("Pop")) {
                try {
                    customStack.pop();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }

            } else {
                customStack.push(Integer.parseInt(line.split("\\s+")[1]));
            }
        }
        for (int i = 0; i < 2; i++) {
            for (Integer element : customStack) {
                System.out.println(element);
            }
        }
    }
}
