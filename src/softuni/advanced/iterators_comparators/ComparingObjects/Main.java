package softuni.advanced.iterators_comparators.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Description:
 * We have to create a Class Person. Each person should have name, age and town.
 * We should implement the interface - Comparable and try to override the compareTo method.
 * When we compare two people, first we should compare their names, after that - their age
 * and last but not at least - compare their town.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String line = "";

        while (!"END".equals(line = scan.nextLine())) {
            String[] personInfo = line.split("\\s+");
            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);
            String town = personInfo[2];

            Person person = new Person(name, age, town);

            people.add(person);
        }
        int index = Integer.parseInt(scan.nextLine());
        Person searchPerson = people.get(index - 1);

        int equalPeople = 0;
        for (Person person : people) {
            if (person.compareTo(searchPerson) == 0) {
                equalPeople++;
            }
        }

        if (equalPeople == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(String.format("%d %d %d", equalPeople, people.size() - equalPeople, people.size()));
        }
    }
}
