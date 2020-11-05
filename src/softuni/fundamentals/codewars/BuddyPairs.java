package softuni.fundamentals.codewars;

public class BuddyPairs {
    public static void main(String[] args) {

    }

    public static String buddy(long min, long max) {
        for (long currentNum = min; currentNum <= max; currentNum++) {
            long sumOfDivisors = divSum(currentNum);
            long possibleBuddy = sumOfDivisors - 1;
            if (possibleBuddy < min) {
                continue;
            }
            long sumOfDivisorsOfPossibleBuddy = divSum(possibleBuddy);
            if (sumOfDivisorsOfPossibleBuddy - 1 == currentNum) {
                return "(" + currentNum + " " + possibleBuddy + ")";
            }
        }
        return "Nothing";
    }

    static long divSum(long num) {
        long result = 0;
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i == (num / i)) {
                    result += i;
                } else {
                    result += (i + num / i);
                }
            }
        }

        // Add 1 to the result as 1 is also
        // a divisor
        return (result + 1);
    }

}
