package softuni.advanced.definingclasses.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

/**Description:
 * We have to create Person class with two fields String name and int age,
 * write a program that reads from the console N lines of personal information and then
 * prints all people whose age is more than 30 years, sorted in alphabetical order.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] newPerson = scan.nextLine().split("\\s+");
            String name = newPerson[0];
            int age = Integer.parseInt(newPerson[1]);

            Person current = new Person(name, age);

            people.add(current);
        }

        Predicate<Person> predicate = p -> p.getAge() > 30;

        people.stream()
                .filter(predicate)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(p -> System.out.printf("%s - %d%n", p.getName(), p.getAge()));

    }
}
