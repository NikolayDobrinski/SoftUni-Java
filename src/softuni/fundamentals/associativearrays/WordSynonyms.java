package softuni.fundamentals.associativearrays;

import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> wordSynonyms = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String word = scan.nextLine();
            String synonym = scan.nextLine();

            List<String> currentSynonyms = wordSynonyms.get(word);

            if (currentSynonyms == null) {
                currentSynonyms = new ArrayList<>();
                wordSynonyms.put(word, currentSynonyms);
            }
            currentSynonyms.add(synonym);
        }
        for (Map.Entry<String, List<String>> entry : wordSynonyms.entrySet()) {
            System.out.println(entry.getKey() + " - " + String.join(", ", entry.getValue()));
        }

    }
}
