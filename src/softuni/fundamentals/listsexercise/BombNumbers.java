package softuni.fundamentals.listsexercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> bombInfo = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());

        int numBomb = bombInfo.get(0);
        int power = bombInfo.get(1);

        while (list.contains(numBomb)) {
            int bombPosition = list.indexOf(numBomb);

            int leftBound = Math.max(0, bombPosition - power);
            int rightBound = Math.min(list.size() - 1, bombPosition + power);

            for (int i = rightBound; i >= leftBound; i--) {
                list.remove(i);
            }
        }
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        System.out.println(sum);

    }
}
