package softuni.fundamentals.finalexamprep;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**Description:
 * You will receive an integer n – the number of pieces that you will initially have.
 * On the next n lines the pieces themselves will follow with their composer and key, separated by "|"
 * in the following format: {piece}|{composer}|{key}.
 * Then, you will be receiving different commands, each on a new line, separated by "|", until the "Stop" command is given:
 * Add|{piece}|{composer}|{key}, Remove|{piece}, ChangeKey|{piece}|{new key};
 * At the end you need to print all pieces in your collection, sorted by their name and by the name of their composer
 * in alphabetical order.
 */

public class ThePianist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, String[]> pianoPieces = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\|");
            String piece = input[0];
            String composer = input[1];
            String key = input[2];

            String[] currentPiece = new String[]{composer, key};
            pianoPieces.put(piece, currentPiece);
        }

        String line = scan.nextLine();

        while (!line.equals("Stop")) {
            String[] command = line.split("\\|");
            String piece = command[1];

            switch (command[0]) {
                case "Add":
                    String composerAdd = command[2];
                    String keyAdd = command[3];
                    if (pianoPieces.containsKey(piece)) {
                        System.out.println(piece + " is already in the collection!");
                    } else {
                        String[] addNew = new String[]{composerAdd, keyAdd};
                        pianoPieces.put(piece, addNew);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composerAdd, keyAdd);
                    }

                    break;
                case "Remove":
                    if (pianoPieces.containsKey(piece)) {
                        pianoPieces.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = command[2];
                    if (pianoPieces.containsKey(piece)) {
                        pianoPieces.get(piece)[1] = newKey;
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }
            line = scan.nextLine();
        }

        pianoPieces
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    int result = a.getKey().compareTo(b.getKey());
                    if (result == 0) {
                        result = a.getValue()[0].compareTo(b.getValue()[0]);
                    }
                    return result;
                })
                .forEach(p -> {
                    System.out.println(p.getKey() + " -> Composer: " + p.getValue()[0] + ", Key: " + p.getValue()[1]);

                });

    }
}

