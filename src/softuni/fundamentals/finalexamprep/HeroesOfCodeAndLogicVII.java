package softuni.fundamentals.finalexamprep;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** Description:
 * Write a program in which you get n number of heroes with their HP /hero points/ and MP /mana points/
 * and perform actions with them. At the end print the heroes sorted in descending order by their hero points.
 */

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, int[]> heroes = new HashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            String name = input[0];
            int hp = Integer.parseInt(input[1]);
            int mp = Integer.parseInt(input[2]);

            int[] currentHero = new int[]{hp, mp};

            heroes.put(name, currentHero);
        }
        String command = scan.nextLine();

        while (!command.equals("End")) {
            String[] actions = command.split(" - ");
            String name = actions[1];

            switch (actions[0]) {
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(actions[2]);
                    String spellName = actions[3];

                    if (heroes.get(name)[1] >= mpNeeded) {
                        heroes.get(name)[1] = heroes.get(name)[1] - mpNeeded;
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                                name, spellName, heroes.get(name)[1]);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", name, spellName);
                    }

                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(actions[2]);
                    String attacker = actions[3];

                    if (heroes.get(name)[0] > damage) {
                        heroes.get(name)[0] = heroes.get(name)[0] - damage;

                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                name, damage, attacker, heroes.get(name)[0]);
                    } else {
                        heroes.remove(name);
                        System.out.printf("%s has been killed by %s!%n", name, attacker);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(actions[2]);
                    if (heroes.get(name)[1] + amount > 200) {

                        int amountRecharged = 200 - heroes.get(name)[1];
                        heroes.get(name)[1] = 200;
                        System.out.printf("%s recharged for %d MP!%n", name, amountRecharged);
                    } else {
                        heroes.get(name)[1] = heroes.get(name)[1] + amount;
                        System.out.printf("%s recharged for %d MP!%n", name, amount);
                    }
                    break;
                case "Heal":
                    int healAmount = Integer.parseInt(actions[2]);
                    if (heroes.get(name)[0] + healAmount > 100) {

                        int amountRecharged = 100 - heroes.get(name)[0];
                        heroes.get(name)[0] = 100;
                        System.out.printf("%s healed for %d HP!%n", name, amountRecharged);
                    } else {
                        heroes.get(name)[0] = heroes.get(name)[0] + healAmount;
                        System.out.printf("%s healed for %d HP!%n", name, healAmount);
                    }
                    break;
            }

            command = scan.nextLine();
        }

        heroes.entrySet().stream().sorted((a, b) -> {
            int result = b.getValue()[0] - a.getValue()[0];
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(h -> {
            System.out.println(h.getKey());
            System.out.println("  HP: " + h.getValue()[0]);
            System.out.println("  MP: " + h.getValue()[1]);
        });
    }
}
