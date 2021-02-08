package softuni.advanced.examprep;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description:
 * We will be given a two sequence of integers, representing bomb effects and bomb casings.
 * We need to start from the first bomb effect and try to mix it with the last bomb casing.
 * If the sum of their values is equal to any of the materials in the table below – we have to
 * create the bomb corresponding to the value and remove the both bomb materials. Otherwise,
 * just decrease the value of the bomb casing by 5. We need to stop combining when we have no more
 * bomb effects or bomb casings, or we successfully filled the bomb pouch with three of each bomb types.
 * Bomb types: Datura Bombs: 40, Cherry Bombs: 60, Smoke Decoy Bombs: 120.
 */

public class Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> bombEffects = Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> bombCasing = Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());

        Map<String, Integer> createdBombs = new TreeMap<>();

        createdBombs.put("Datura Bombs", 0);
        createdBombs.put("Cherry Bombs", 0);
        createdBombs.put("Smoke Decoy Bombs", 0);

        Boolean isFinished = false;

            for (int i = 0; i < bombEffects.size(); i++) {

                if (bombEffects.get(i) + bombCasing.get(bombCasing.size() - 1 - i) == 40) {
                    Integer currentDaturaBombs = createdBombs.get("Datura Bombs");
                    createdBombs.put("Datura Bombs", currentDaturaBombs + 1);
                    bombEffects.remove(i);
                    bombCasing.remove(bombCasing.size() - 1 - i);
                } else if (bombEffects.get(i) + bombCasing.get(bombCasing.size() - 1 - i) == 60) {
                    Integer currentCherryBombs = createdBombs.get("Cherry Bombs");
                    createdBombs.put("Cherry Bombs", currentCherryBombs + 1);
                    bombEffects.remove(i);
                    bombCasing.remove(bombCasing.size() - 1 - i);
                } else if (bombEffects.get(i) + bombCasing.get(bombCasing.size() - 1 - i) == 120) {
                    Integer currentSmokeDecoyBombs = createdBombs.get("Smoke Decoy Bombs");
                    createdBombs.put("Smoke Decoy Bombs", currentSmokeDecoyBombs + 1);
                    bombEffects.remove(i);
                    bombCasing.remove(bombCasing.size() - 1 - i);
                } else {
                    Integer currentValue = bombCasing.get(bombCasing.size() - 1 - i);
                    bombCasing.set((bombCasing.size() - 1 - i), currentValue - 5);
                }
                i--;
                if (createdBombs.get("Datura Bombs") > 2 && createdBombs.get("Cherry Bombs") > 2
                        && createdBombs.get("Smoke Decoy Bombs") > 2) {
                    isFinished = true;
                    break;
                }
                if (bombEffects.isEmpty() || bombCasing.isEmpty()) {
                    break;
                }
            }

        if (!isFinished) {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        } else {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }

        if (bombEffects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            System.out.print(String.join(", ", bombEffects.toString().replaceAll("[\\[\\]]", "")));
            System.out.println();
        }

        if (bombCasing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            System.out.print(String.join(", ", bombCasing.toString().replaceAll("[\\[\\]]", "")));
            System.out.println();
        }
        createdBombs.entrySet().stream().forEach(b -> System.out.println(b.getKey() + ": " + b.getValue()));
    }
}
