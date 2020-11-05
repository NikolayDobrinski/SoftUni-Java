package softuni.fundamentals.labs.dbvariables;

public class WithSameBits {
    public static void main(String[] args) {

        int n = 323423;
        String result = Integer.toBinaryString(n);

        int counter1 = 0;

        for (int i = 0; i < result.length(); i++) {
            char current = result.charAt(i);

            if (current == 49) {
                counter1++;
            }
        }
        int counter2 = 0;

        for (int i = n + 1; i < Integer.MAX_VALUE; i++) {
            String current = Integer.toBinaryString(i);

            for (int j = 0; j < current.length(); j++) {
                char ones = current.charAt(j);
                if (ones == 49) {
                    counter2++;
                }
                if (counter1 == counter2) {
                    System.out.println(i);
                    break;
                }
            }

        }


    }
}
