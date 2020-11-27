package softuni.fundamentals.finalexamprep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String expression = "(:{2}|\\*{2})([A-Z][a-z]{2,})(\\1)";
        String expressionNumber = "\\d";

        String text = scan.nextLine();
        List<String> listWords = new ArrayList<>();

        Pattern pattern = Pattern.compile(expressionNumber);
        Matcher matcher = pattern.matcher(text);

        int coolThreshold = 1;

        while (matcher.find()) {
            coolThreshold *= Integer.parseInt(matcher.group());
        }

        Pattern patternWords = Pattern.compile(expression);
        Matcher matcherWords = patternWords.matcher(text);

        while (matcherWords.find()) {
            listWords.add(matcherWords.group());
        }

        System.out.printf("Cool threshold: %d%n", coolThreshold);
        int emojiCount = listWords.size();
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojiCount);

        for (String s : listWords) {
            int sumChars = 0;
            for (int i = 0; i < s.length(); i++) {
                char currentS = s.charAt(i);
                if (Character.isLetter(currentS)) {
                    sumChars += currentS;
                }
            }
            if (sumChars > coolThreshold) {
                System.out.println(s);
            }
        }
    }
}
