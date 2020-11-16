package softuni.fundamentals.associativearrays;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Double>> students = new HashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            Double grade = Double.parseDouble(scan.nextLine());
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        students.entrySet()
                .stream()
                .filter(e -> e.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble() >= 4.50)
                .sorted((a, b) -> {
                    double firstAverage = a.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    double secondAverage = b.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    return Double.compare(secondAverage, firstAverage);
                }).forEach(s -> {
            System.out.printf("%s -> %.2f%n", s.getKey(), s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble());
        });


    }
}
