package softuni.fundamentals.midexamprep;

import java.util.Scanner;

public class ArrayModifier {

    public static int[] parseArray(String numbers) {
        String[] numbersString = numbers.split(" ");
        int[] array = new int[numbersString.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(numbersString[i]);
        }
        return array;
    }

    public static void swap(int[] array, int indexA, int indexB) {
        int old = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = old;
    }

    public static void multiply(int[] array, int indexA, int indexB) {
        array[indexA] = array[indexA] * array[indexB];
    }

    public static void decrease(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i]--;
        }
    }

    public static void printArray(String separator, int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(separator);
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String lineOfNumbers = scan.nextLine();

        int[] array = parseArray(lineOfNumbers);

        String command = scan.nextLine();

        while (!command.equals("end")) {
            String[] currentCommand = command.split(" ");

            switch (currentCommand[0]) {
                case "swap":
                    swap(array, Integer.parseInt(currentCommand[1]), Integer.parseInt(currentCommand[2]));
                    break;
                case "multiply":
                    multiply(array, Integer.parseInt(currentCommand[1]), Integer.parseInt(currentCommand[2]));
                    break;
                case "decrease":
                    decrease(array);
                    break;
            }
            command = scan.nextLine();

        }

        printArray(", ", array);


    }
}
