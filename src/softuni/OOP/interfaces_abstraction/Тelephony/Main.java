package softuni.OOP.interfaces_abstraction.Тelephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] numbers = scan.nextLine().split("\\s+");
        List<String> numbersList = Arrays.asList(numbers);

        String[] urls = scan.nextLine().split("\\s+");
        List<String> urlsList = Arrays.asList(urls);

        try {
            Smartphone smartphone = new Smartphone(numbersList, urlsList);
            System.out.println(smartphone.call());
            System.out.println(smartphone.browse());
        } catch (IllegalArgumentException ex){
            throw new IllegalArgumentException("Invalid input!");
        }

    }
}
