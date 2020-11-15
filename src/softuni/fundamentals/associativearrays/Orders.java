package softuni.fundamentals.associativearrays;

import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Double>> list = new LinkedHashMap<>();

        String command = scan.nextLine();


        while (!command.equals("buy")) {
            String[] current = command.split(" ");
            String key = current[0];
            double price = Double.parseDouble(current[1]);
            double quantity = Double.parseDouble(current[2]);

            List<Double> currentList = list.get(key);

            if (list.containsKey(key)) {
                double currentPrice = currentList.get(0);
                double currentQuantity = currentList.get(1);

                if (currentPrice != price) {
                    currentList.set(0, price);
                }
                currentList.set(1, currentQuantity + quantity);
            } else {

                currentList = new ArrayList<>();
                currentList.add(0, price);
                currentList.add(1, quantity);

                list.put(key, currentList);
            }
            command = scan.nextLine();
        }
        for (Map.Entry<String, List<Double>> entry : list.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue().get(0) * entry.getValue().get(1));
        }

    }
}
