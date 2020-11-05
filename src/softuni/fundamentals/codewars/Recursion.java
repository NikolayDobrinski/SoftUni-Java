package softuni.fundamentals.codewars;

public class Recursion {
    public static void main(String[] args) {

        int a = 6;
        int b = 19;

        if (a == 0 || b == 0) {
            System.out.printf("%d %d", a, b);
            return;
        } else if (a >= 2 * b) {
            a = a - 2 * b;

            if (a == 0 || b == 0) {
                System.out.printf("%d %d", a, b);
                return;
            }
            if (a >= 2 * b) {
                a = a - 2 * b;
            }

            if (b >= 2 * a) {
                b = b - 2 * a;
                if (a >= 2 * b) {
                    a = a - 2 * b;
                }
                if (b >= 2 * a) {
                    b = b - 2 * a;
                }
            }
        } else if (b >= 2 * a) {
            b = b - 2 * a;
            if (a == 0 || b == 0) {
                System.out.printf("%d %d", a, b);
                return;
            }
            if (a >= 2 * b) {
                a = a - 2 * b;
            }
            if (b >= 2 * a) {
                b = b - 2 * a;
                if (a >= 2 * b) {
                    a = a - 2 * b;
                }
                if (b >= 2 * a) {
                    b = b - 2 * a;
                }
            }
        }
        System.out.printf("%d %d", a, b);

    }
}
