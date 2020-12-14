package softuni.fundamentals.finalexam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**Description:
 * Write a program, that checks if inputs have valid message and decrypt it.
 * Message is valid when:
 * - there is nothing else before and after it;
 * - it starts with a tag, which is surrounded by either $ or %;
 *  - tag itself has to be min 3 characters long, start with a uppercase letter followed only by lowercase letters;
 *  - there is a colon and single white space after the tag;
 *  - there are 3 groups consisting ot numbers between [ and ], followed by a pipe | ;
 */

public class Problem2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String regex = "^([$|%])([A-Z][a-z]{2,})\\1\\:\\s\\[(\\d+)\\]\\|\\[(\\d+)\\]\\|\\[(\\d+)\\]\\|$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n ; i++) {
            String message = scan.nextLine();

            Matcher matcher = pattern.matcher(message);

                if (matcher.find()) {
                    String tag = matcher.group(2);
                    int numberOne = Integer.parseInt(matcher.group(3));
                    int numberTwo = Integer.parseInt(matcher.group(4));
                    int numberThree = Integer.parseInt(matcher.group(5));

                    System.out.print(tag + ": ");
                    System.out.print((char) numberOne);
                    System.out.print((char) numberTwo);
                    System.out.print((char) numberThree);
                    System.out.println();

                }
                else {
                    System.out.println("Valid message not found!");
                }
            }

        }
    }

