package softuni.advanced.examprep;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description:
 * We will receive two sequences of integers, representing the number of materials for crafting toys and their magic level.
 * Our task is to mix materials with magic so we can craft presents, listed below with the exact magic level.
 * Doll - 150, Wooden train - 250, Teddy bear - 300 and Bicycle - 400.
 * In order to craft a toy, we have to take the last box with materials and the first magic level value.
 * The total magic level is calculated by their multiplication. If the result equals one of the
 * levels described above, we craft the present and remove both materials and magic value. Otherwise:
 * If the product of the operation is a negative number, then we have to sum the values together, remove them both from their
 * positions and the result should be added to the materials.
 * If the product doesn’t equal one of the magic levels in the table and is a positive number, we remove only the magic value
 * and increase the material value with 15.
 * If the magic or material (or both) equals 0, remove it (or both) and continue crafting the presents.
 * We have to stop crafting presents when we run out of boxes of materials or magic level values. Our task is considered
 * done if we manage to craft either one of the pairs - a doll and a train or a teddy bear and a bicycle.
 */

public class SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Stack - materials
        ArrayDeque<Integer> materials = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(materials::push);

        //Queue - magic
        ArrayDeque<Integer> magic = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Map<String, Integer> presents = new TreeMap<>();

        presents.put("Doll", 0);
        presents.put("Wooden train", 0);
        presents.put("Teddy bear", 0);
        presents.put("Bicycle", 0);

        boolean isSuccess = false;

        while (!materials.isEmpty() && !magic.isEmpty()) {
            int currentMaterial = materials.pop();
            int currentMagic = magic.poll();
            int multip = currentMaterial * currentMagic;

            if (multip == 150) {
                int currentDolls = presents.get("Doll");
                presents.put("Doll", currentDolls + 1);
            } else if (multip == 250) {
                int currentTrains = presents.get("Wooden train");
                presents.put("Wooden train", currentTrains + 1);
            } else if (multip == 300) {
                int currentBear = presents.get("Teddy bear");
                presents.put("Teddy bear", currentBear + 1);
            } else if (multip == 400) {
                int currentBicycle = presents.get("Bicycle");
                presents.put("Bicycle", currentBicycle + 1);
            } else if (multip < 0) {
                int sum = currentMaterial + currentMagic;
                materials.push(sum);
            } else if (multip > 0 && multip != 150 && multip != 250 && multip != 300 && multip != 400) {
                int newMaterial = currentMaterial + 15;
                materials.push(newMaterial);
            } else if (multip == 0) {
                if (currentMaterial == 0) {
                    magic.offerFirst(currentMagic);
                } else {
                    materials.push(currentMaterial);
                }
            }

            if (presents.get("Doll") > 0 && presents.get("Wooden train") > 0 || presents.get("Teddy bear") > 0
                    && presents.get("Bicycle") > 0) {
                isSuccess = true;
                break;
            }
        }
        if (isSuccess) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!materials.isEmpty()) {
            List<String> materialsResult = new ArrayList<>();
            System.out.print("Materials left: ");
            materials.stream().forEach(m -> materialsResult.add(m.toString()));
            System.out.println(String.join(", ", materialsResult));
        }
        if (!magic.isEmpty()) {
            List<String> magicResult = new ArrayList<>();
            System.out.print("Magic left: ");
            magic.stream().forEach(m -> magicResult.add(m.toString()));
            System.out.println(String.join(", ", magicResult));
        }
        presents.entrySet().stream().filter(p -> p.getValue() != 0)
                .forEach(p -> System.out.println(p.getKey() + ": " + p.getValue()));
    }
}
