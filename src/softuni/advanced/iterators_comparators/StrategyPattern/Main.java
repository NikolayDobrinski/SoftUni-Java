package softuni.advanced.iterators_comparators.StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/** Description
 * We have to create a class Person that holds name and age. Create 2 Comparators for Person
 * (classes which implement the Comparator<Person> interface). The first comparator should compare
 * people based on the length of their name as a first parameter, if 2 people have a name with the
 * same length, perform a case-insensitive compare based on the first letter of their name instead.
 * The second comparator should compare them based on their age. Create 2 TreeSets of type Person,
 * the first should implement the name comparator and the second should implement the age comparator.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<Person> peopleByName = new TreeSet<>(new ComparatorByName());
        Set<Person> peopleByAge = new TreeSet<>(new ComparatorByAge());

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            peopleByAge.add(person);
            peopleByName.add(person);
        }
        peopleByName.forEach(p -> System.out.println(p.toString()));
        peopleByAge.forEach(p -> System.out.println(p.toString()));
    }
}
