package softuni.fundamentals.exercise.dbvariables;

import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scan.nextLine());
        int secondNumber = Integer.parseInt(scan.nextLine());
        int thirdNumber = Integer.parseInt(scan.nextLine());
        int fourthNumber = Integer.parseInt(scan.nextLine());

        int result = ((firstNumber + secondNumber) / thirdNumber) * fourthNumber;

        System.out.println(result);

    }
}
