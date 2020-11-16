package softuni.fundamentals.associativearrays;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();
        String command = scan.nextLine();

        while (!command.equals("end")) {
            String[] current = command.split(" : ");
            String course = current[0];
            String student = current[1];

            if (!courses.containsKey(course)) {
                courses.put(course, new ArrayList<>());
            }
            courses.get(course).add(student);
            command = scan.nextLine();
        }

        courses.entrySet().stream().sorted((a, b) -> b.getValue().size() - a.getValue().size()).
                forEach(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue().size());
                    e.getValue()
                            .stream()
                            .sorted((a, b) -> a.compareTo(b))
                            .forEach(b -> System.out.println("-- " + b));
                });


    }
}
