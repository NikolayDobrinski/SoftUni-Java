package softuni.advanced.examprep;

import java.util.*;
import java.util.stream.Collectors;

/** Description:
 * We will be given two sequences of integers, representing liquids and ingredients.
 * We need to start from the first liquid and try to mix it with the last ingredient.
 * If the sum of their values is equal to 25, 50, 75 or 100 – we cook the food corresponding
 * to the value and remove both the liquid and the ingredient. Otherwise, we remove only the
 * liquid and increase the value of the ingredient by 3. We need to stop combining when we have
 * no more liquids or ingredients.
 */

public class Cooking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Queue

        ArrayDeque<Integer> liquids = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        //Stack

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredients::push);

        Map<Integer, String> cookingTable = new HashMap<>();

        cookingTable.put(25, "Bread");
        cookingTable.put(50, "Cake");
        cookingTable.put(75, "Pastry");
        cookingTable.put(100, "Fruit Pie");

        Map<String, Integer> productsCooked = new TreeMap<>();

        cookingTable.values().forEach(p -> productsCooked.put(p, 0));

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {

            int currentLiquid = liquids.poll();
            int currentIngredient = ingredients.pop();

            int sum = currentLiquid + currentIngredient;

            if (ableToCookProduct(sum)) {
                String product = cookingTable.get(sum);
                int oldValue = productsCooked.get(product);
                productsCooked.put(product, oldValue + 1);
            } else {
                ingredients.push(currentIngredient + 3);
            }
        }

        if (hasCookedEachMeal(productsCooked)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }
        else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }

        System.out.println("Liquids left: " + getElementsInfo(liquids));
        System.out.println("Ingredients left: " + getElementsInfo(ingredients));

        productsCooked.forEach((k, v) -> System.out.println(k + ": " + v));

    }

    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty()
                ? "none"
                : deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    private static boolean hasCookedEachMeal(Map<String, Integer> productsCooked) {
        return productsCooked.values().stream().noneMatch(c -> c == 0);
    }

    private static boolean ableToCookProduct(int sum) {
        return sum == 25 || sum == 50 || sum == 75 || sum == 100;
    }
}
