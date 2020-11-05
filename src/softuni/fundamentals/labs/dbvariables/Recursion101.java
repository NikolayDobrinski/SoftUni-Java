package softuni.fundamentals.labs.dbvariables;

public class Recursion101 {
    public static void main(String[] args) {

        int a = 22;
        int b = 5;

        if (a == 0 || b == 0) {
            System.out.printf("%d %d", a, b);
        }
        if (a >= 2 * b) {
            a = a - 2 * b;
            if (a == 0 || b == 0) {
                System.out.printf("%d %d", a, b);
            } else {
                System.out.printf("%d %d", a, b);
            }
        }
        if (b >= 2 * a) {
            b = b - 2 * a;
            if (a == 0 || b == 0) {
                System.out.printf("%d %d", a, b);
            } else {
                System.out.printf("%d %d", a, b);
            }
        }


    }
}


