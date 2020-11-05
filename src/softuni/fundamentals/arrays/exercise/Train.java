package softuni.fundamentals.arrays.exercise;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int vagons = Integer.parseInt(scan.nextLine());

        int[] train = new int[vagons];

        for (int i = 0; i < vagons; i++) {
            int currentVagon = Integer.parseInt(scan.nextLine());
            train[i] = currentVagon;
        }
        int sumPasengers = 0;

        for (int i = 0; i < train.length; i++) {
            System.out.print(train[i] + " ");
            sumPasengers += train[i];
        }
        System.out.println();
        System.out.println(sumPasengers);


    }
}
