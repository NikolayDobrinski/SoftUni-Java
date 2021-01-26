package softuni.advanced.streamsfilesdirectories;

import java.io.*;
import java.util.Set;

/**Description:
 * We have to write a program that reads a list of words from file and finds the count of vowels,
 * consonants and punctuation marks. Then we have to write them in another file using PrintWriter.
 */

public class CountCharacterTypes {

    private static final String INPUT_PATH = "src\\softuni\\advanced\\streamsfilesdirectories\\resources\\input.txt";
    private static final String OUTPUT_PATH = "src\\softuni\\advanced\\streamsfilesdirectories\\resources\\output.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)){

            Set<Character> vowels = Set.of('a', 'e', 'o', 'u', 'i');
            Set<Character> punctuationMarks = Set.of(',', '.', '!', '?');

            int vowelsCount = 0;
            int consonantsCount = 0;
            int punctuationMarksCount = 0;

            String line = reader.readLine();

            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);

                    if (vowels.contains(symbol)) {
                        vowelsCount++;
                    }
                    else if (punctuationMarks.contains(symbol)) {
                        punctuationMarksCount++;
                    }
                    else if (symbol != ' ') {
                        consonantsCount++;
                    }
                }
                line = reader.readLine();
            }
            writer.println("Vowels: " + vowelsCount);
            writer.println("Consonants: " + consonantsCount);
            writer.println("Punctuation: " + punctuationMarksCount);
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
