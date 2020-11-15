package softuni.fundamentals.associativearrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new HashMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        boolean obtained = false;

        while (!obtained) {
            String[] input = scan.nextLine().split("\\s+");

            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                    if (keyMaterials.get(material) >= 250) {
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        if (material.equals("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        } else if (material.equals("fragments")) {
                            System.out.println("Valanyr obtained!");
                        } else {
                            System.out.println("Dragonwrath obtained!");
                        }
                        obtained = true;
                        break;
                    }
                } else {
                    junkMaterials.putIfAbsent(material, 0);
                    junkMaterials.put(material, junkMaterials.get(material) + quantity);
                }
            }
        }
        keyMaterials.entrySet()
                .stream()
                .sorted((a, b) -> {
                            int result = b.getValue().compareTo(a.getValue());
                            if (result == 0) {
                                result = a.getKey().compareTo(b.getKey());
                            }
                            return result;
                        }
                ).forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        junkMaterials.forEach((k, v) -> System.out.println(k + ": " + v));

    }
}
