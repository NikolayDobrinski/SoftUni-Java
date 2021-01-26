package softuni.advanced.streamsfilesdirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**Description:
 * We have to write a program that reads a list of words from file finds how many times each of the words is contained
 * in another file. Then we have to write the results in third file sorted by frequency in descending order.
 */

public class WordCount {

    private static final String WORDS_INPUT_PATH = "src\\softuni\\advanced\\streamsfilesdirectories\\resources\\words.txt";
    private static final String TEXT_INPUT_PATH = "src\\softuni\\advanced\\streamsfilesdirectories\\resources\\text.txt";
    private static final String OUTPUT_PATH = "src\\softuni\\advanced\\streamsfilesdirectories\\resources\\results.txt";

    public static void main(String[] args) {

        try (BufferedReader wordsReader = new BufferedReader(new FileReader(WORDS_INPUT_PATH));
             BufferedReader textReader = new BufferedReader(new FileReader(TEXT_INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            Map<String, Integer> wordOccurrences = new HashMap<>();

            String[] wordsLine = wordsReader.readLine().split("\\s+");

            for (int i = 0; i < wordsLine.length; i++) {
                wordOccurrences.put(wordsLine[i], 0);
            }

            String[] textLine = textReader.readLine().split("\\s+");

            for (String word : textLine) {
                if (wordOccurrences.containsKey(word)) {
                    int newValue = wordOccurrences.get(word) + 1;
                    wordOccurrences.put(word, newValue);
                }
            }
            wordOccurrences.entrySet()
                    .stream()
                    .sorted((w1, w2) -> w2.getValue().compareTo(w1.getValue()))
                    .forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
