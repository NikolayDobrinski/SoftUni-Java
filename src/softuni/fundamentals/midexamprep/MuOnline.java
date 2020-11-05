package softuni.fundamentals.midexamprep;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] rooms = scan.nextLine().split("\\|");

        int health = 100;
        int bitcoins = 0;

        for (int i = 0; i < rooms.length; i++) {

            String[] currentRoom = rooms[i].split(" ");
            String action = currentRoom[0];

            switch (action) {
                case "potion":
                    int addedHealth = 0;
                    int additionalHelath = Integer.parseInt(currentRoom[1]);
                    if (additionalHelath + health > 100) {
                        addedHealth = 100 - health;
                        health = 100;
                    } else {
                        addedHealth = additionalHelath;
                        health += additionalHelath;
                    }
                    System.out.printf("You healed for %d hp.%n", addedHealth);
                    System.out.printf("Current health: %d hp.%n", health);
                    addedHealth = 0;
                    break;
                case "chest":
                    int bitcoin = Integer.parseInt(currentRoom[1]);
                    bitcoins += bitcoin;
                    System.out.printf("You found %d bitcoins.%n", bitcoin);
                    break;
                default:
                    String monster = currentRoom[0];
                    int monstersPower = Integer.parseInt(currentRoom[1]);

                    if (health - monstersPower <= 0) {
                        System.out.printf("You died! Killed by %s.%n", monster);
                        System.out.printf("Best room: %d", i + 1);
                        return;
                    } else {
                        health -= monstersPower;
                        System.out.printf("You slayed %s.%n", monster);
                    }
            }
        }
        System.out.printf("You've made it!%n");
        System.out.printf("Bitcoins: %d%n", bitcoins);
        System.out.printf("Health: %d", health);

    }
}
