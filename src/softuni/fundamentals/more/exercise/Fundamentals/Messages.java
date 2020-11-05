package softuni.fundamentals.more.exercise.Fundamentals;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String number = scan.nextLine();
        int numberConverted = Integer.parseInt(number);
        String output = "";

        for (int i = 1; i <= numberConverted; i++) {

            String current = scan.nextLine();

            int lenght = current.length();

            String letter = "";

            if (lenght == 1) {
                if (current.equals("2")) {
                    letter += "a";
                } else if (current.equals("3")) {
                    letter += "d";
                } else if (current.equals("4")) {
                    letter += "g";
                } else if (current.equals("5")) {
                    letter += "j";
                } else if (current.equals("6")) {
                    letter += "m";
                } else if (current.equals("7")) {
                    letter += "p";
                } else if (current.equals("8")) {
                    letter += "t";
                } else if (current.equals("9")) {
                    letter += "w";
                } else if (current.equals("0")) {
                    letter += " ";
                }
            } else if (lenght == 2) {
                if (current.equals("22")) {
                    letter += "b";
                } else if (current.equals("33")) {
                    letter += "e";
                } else if (current.equals("44")) {
                    letter += "h";
                } else if (current.equals("55")) {
                    letter += "k";
                } else if (current.equals("66")) {
                    letter += "n";
                } else if (current.equals("77")) {
                    letter += "q";
                } else if (current.equals("88")) {
                    letter += "u";
                } else if (current.equals("99")) {
                    letter += "x";
                }
            } else if (lenght == 3) {
                if (current.equals("222")) {
                    letter += "c";
                } else if (current.equals("333")) {
                    letter += "f";
                } else if (current.equals("444")) {
                    letter += "i";
                } else if (current.equals("555")) {
                    letter += "l";
                } else if (current.equals("666")) {
                    letter += "o";
                } else if (current.equals("777")) {
                    letter += "r";
                } else if (current.equals("888")) {
                    letter += "v";
                } else if (current.equals("999")) {
                    letter += "y";
                }
            } else if (lenght == 4) {
                if (current.equals("7777")) {
                    letter += "s";
                } else if (current.equals("9999")) {
                    letter += "z";
                }
            }

            output += letter;
        }
        System.out.printf("%s", output);


    }
}
