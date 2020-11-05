package softuni.fundamentals.objectsandclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll {
    static class Opinion {
        String name;
        int age;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String toString() {
            return String.format("%s - %d", getName(), getAge());
        }

        public Opinion(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Opinion> allPersons = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] currentOpinion = scan.nextLine().split(" ");
            String name = currentOpinion[0];
            int age = Integer.parseInt(currentOpinion[1]);

            Opinion person = new Opinion(name, age);

            allPersons.add(person);

        }

        allPersons.stream().filter(opinion -> opinion.getAge() > 30).sorted((p1, p2) -> p1.getName().
                compareTo(p2.getName())).forEach(person -> System.out.println(person.toString()));

    }
}
