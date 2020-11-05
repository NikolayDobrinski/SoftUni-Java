package softuni.fundamentals.labs.dbvariables;

import java.util.Scanner;

public class CocaCola {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] names = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};

        int n = 1;

        if (n <= names.length) {
            for (int i = 0; i < n; i++) {
                String firstName = names[0];

                for (int j = 0; j < names.length - 1; j++) {
                    names[j] = names[j + 1];
                }
                names[names.length - 1] = firstName;
            }
            for (int i = 0; i < names.length; i++) {
                System.out.print(names[i] + " ");
            }
        } else if (n > names.length) {

            for (int i = 1; i <= n; i++) {
                if (i % 2 != 0) {
                    String firstName = names[0];

                    for (int j = 0; j < names.length - 1; j++) {
                        names[j] = names[j + 1];
                    }
                    names[names.length - 1] = firstName;
                }
            }

            for (int i = 0; i < names.length; i++) {
                System.out.print(names[i] + " ");
            }
        }


    }
}



