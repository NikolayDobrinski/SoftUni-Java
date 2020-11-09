package codewars.chalenges;

public class BitCounting {

    public static int countBits(int n) {

        String bits = Integer.toBinaryString(n);
        int counter = 0;

        for (int i = 0; i < bits.length(); i++) {
            char currentDigit = bits.charAt(i);
            if (currentDigit == 49) {
                counter++;
            }
        }
        return counter;
    }
}
