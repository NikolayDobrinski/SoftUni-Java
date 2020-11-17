package softuni.fundamentals.associativearrays;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> users = new TreeMap<>();

        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] currentInput = input.split(" -> ");
            String company = currentInput[0];
            String id = currentInput[1];

            if (!users.containsKey(company)) {
                users.putIfAbsent(company, new ArrayList<>());
                users.get(company).add(id);

            } else {
                if (!users.get(company).contains(id)) {
                    users.get(company).add(id);
                }
            }
            input = scan.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : users.entrySet()) {
            System.out.println(entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.println("-- " + entry.getValue().get(i));
            }
        }
    }
}
