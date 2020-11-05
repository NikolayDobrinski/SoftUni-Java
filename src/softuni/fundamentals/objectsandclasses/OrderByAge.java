package softuni.fundamentals.objectsandclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OrderByAge {
    static class Information {
        String name;
        String id;
        int age;

        Information(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }


        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public int getAge() {
            return age;
        }

        public String toString() {
            return String.format("%s with ID: %s is %d years old.", getName(), getId(), getAge());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        List<Information> allCustomers = new ArrayList<>();

        while (!command.equals("End")) {

            String[] currentCustomer = command.split(" ");
            Information information = new Information(currentCustomer[0], currentCustomer[1],
                    Integer.parseInt(currentCustomer[2]));

            allCustomers.add(information);

            command = scan.nextLine();

        }

        List<Information> sortedCustomers = allCustomers.stream().sorted((s1, s2) -> Integer.compare(s1.getAge(),
                s2.getAge())).collect(Collectors.toList());

        for (int i = 0; i < sortedCustomers.size(); i++) {
            System.out.println(sortedCustomers.get(i).toString());
        }

    }
}
