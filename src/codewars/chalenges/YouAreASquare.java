package codewars.chalenges;

public class YouAreASquare {

    public static boolean isSquare(int n) {

        double m = Math.sqrt(n * 1.0);

        if (n >= 0 && m % 1 == 0){
            return true;
        }
        else {
            return false;
        }
    }
}
