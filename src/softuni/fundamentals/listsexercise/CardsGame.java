package softuni.fundamentals.listsexercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> playerOne = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> playerTwo = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());

        while ((playerOne.size() > 0 && playerTwo.size() > 0)) {
            int first = playerOne.get(0);
            int second = playerTwo.get(0);

            if (playerOne.get(0) > playerTwo.get(0)) {
                playerOne.add(first);
                playerOne.add(second);
            } else if (playerOne.get(0) < playerTwo.get(0)) {
                playerTwo.add(first);
                playerTwo.add(second);
            }
            playerOne.remove(0);
            playerTwo.remove(0);

        }
        if (playerOne.size() > 0) {
            int sum = 0;
            for (Integer integer : playerOne) {
                sum += integer;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        } else {
            int sum = 0;
            for (Integer integer : playerTwo) {
                sum += integer;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        }


    }
}
