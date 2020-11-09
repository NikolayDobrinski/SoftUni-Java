package codewars.chalenges;

public class BitsConv {
    public static void main(String[] args) {

        int n = 128;
        String result = Integer.toBinaryString(n);
        int output = 0;
        boolean completed = false;

        int counter1 = 0;

        for (int i = 0; i < result.length(); i++) {
            char current = result.charAt(i);

            if (current == '1') {
                counter1++;
            }
        }

        int counter2 = 0;
        int counter3 = n + 1;

        while (!completed) {

            String current = Integer.toBinaryString(counter3);
            counter2 = 0;
            counter3++;

            for (int j = 0; j < current.length(); j++) {
                char ones = current.charAt(j);
                if (ones == '1') {
                    counter2++;
                }
                if (counter1 == counter2 && j == current.length() - 1) {
                    completed = true;
                    output = counter3 - 1;
                    break;
                }
            }
        }
        System.out.println(output);
    }
}
