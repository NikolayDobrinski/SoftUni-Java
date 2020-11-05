package softuni.fundamentals.exercise.fundamentals;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String userName = scan.nextLine();
        String passWord = scan.nextLine();
        StringBuffer reversed = new StringBuffer(userName);

        reversed.reverse();
        int counter = 1;
        String result = "" + reversed;

        while (!passWord.equals(result)) {

            if (counter == 4) {
                System.out.printf("User %s blocked!", userName);
                return;
            }
            System.out.println("Incorrect password. Try again.");
            counter++;
            passWord = scan.nextLine();
        }

        System.out.printf("User %s logged in.", userName);


    }
}

