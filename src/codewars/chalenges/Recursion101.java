package codewars.chalenges;

public class Recursion101 {

        public static int [] solve(int a, int b){

            int [] result = new int[2];

            while (a >= (2 * b) || b >= (2 * a)) {
                if (a == 0 || b == 0) {
                    result[0] = a;
                    result[1] = b;
                    return result;
                } else if (a >= (2 * b)) {
                    a =a - (2 * b);
                } else if (b >= 2 * a) {
                    b =b - (2 * a);
                }
            }
            result [0] = a;
            result [1] = b;
            return result;
        }
    }
