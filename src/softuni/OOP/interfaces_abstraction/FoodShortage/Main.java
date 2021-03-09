package softuni.OOP.interfaces_abstraction.FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Buyer> buyerList = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] tokens = scan.nextLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String idOrGroup = tokens[2];
            Buyer buyer = null;

            if (tokens.length == 4) {
                String birthDate = tokens[3];
                buyer = new Citizen(name, age, idOrGroup, birthDate);
            } else if (tokens.length == 3) {
                buyer = new Rebel(name, age, idOrGroup);
            } else {
                throw new IllegalArgumentException("Wrong parameters");
            }
            buyerList.add(buyer);
        }

        String name = scan.nextLine();

        while (!name.equals("End")) {
            for (Buyer person : buyerList) {
                if (name.equals(person.getName())) {
                    person.buyFood();
                    break;
                }
            }
            name = scan.nextLine();
        }

        int totalFood = 0;
        for (Buyer buyer : buyerList) {
            totalFood += buyer.getFood();
        }

        System.out.println(totalFood);
    }
}
