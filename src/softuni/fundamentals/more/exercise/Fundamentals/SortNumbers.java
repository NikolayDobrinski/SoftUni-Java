package softuni.fundamentals.more.exercise.Fundamentals;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numOne = Integer.parseInt(scan.nextLine());
        int numTwo = Integer.parseInt(scan.nextLine());
        int numThree = Integer.parseInt(scan.nextLine());

        if (numOne > numTwo && numOne > numThree && numTwo >= numThree) {
            System.out.println(numOne);
            System.out.println(numTwo);
            System.out.println(numThree);
        } else if (numOne > numTwo && numOne > numThree && numThree >= numTwo) {
            System.out.println(numOne);
            System.out.println(numThree);
            System.out.println(numTwo);
        } else if (numTwo > numOne && numTwo > numThree && numOne >= numThree) {
            System.out.println(numTwo);
            System.out.println(numOne);
            System.out.println(numThree);
        } else if (numTwo > numOne && numTwo > numThree && numThree >= numOne) {
            System.out.println(numTwo);
            System.out.println(numThree);
            System.out.println(numOne);
        } else if (numThree > numTwo && numThree > numOne && numOne >= numTwo) {
            System.out.println(numThree);
            System.out.println(numOne);
            System.out.println(numTwo);
        } else if (numThree > numTwo && numThree > numOne && numOne <= numTwo) {
            System.out.println(numThree);
            System.out.println(numTwo);
            System.out.println(numOne);
        }


    }
}
