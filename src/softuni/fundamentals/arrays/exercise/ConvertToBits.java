package softuni.fundamentals.arrays.exercise;

public class ConvertToBits {
    public static void main(String[] args) {

        int n = 128;
        String result = Integer.toBinaryString(n);
        int output = 0;

        int counter1 = 0;

        for (int i = 0; i < result.length(); i++) {
            char current = result.charAt(i);

            if (current == 49) {
                counter1++;
            }
        }
        boolean foundNexdBigger = false;
        int counter2 = 0;

        for (int i = n + 1; i < 999999; i++) {
            String current = Integer.toBinaryString(i);
            counter2 = 0;

            for (int j = 0; j < current.length(); j++) {
                char ones = current.charAt(j);
                if (ones == 49) {
                    counter2++;
                }
                if (counter1 == counter2 && j == current.length() - 1) {
                    foundNexdBigger = true;
                    output = i;
                    System.out.println(output);
                    return;
                }
            }
        }
    }
}
