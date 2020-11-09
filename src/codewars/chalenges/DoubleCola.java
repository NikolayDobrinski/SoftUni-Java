package codewars.chalenges;

public class DoubleCola {

        public static String WhoIsNext(String[] names, long n) {
            String currentName = names[0];
            int pow = 0;
            long counter = 1;
            while (true) {
                for (int b1 = 0; b1 < names.length; b1++) {
                    currentName = names[b1 % names.length];
                    for (int b2 = 1; b2 <= Math.pow(2, pow); b2++) {
                        if (counter == n) {
                            return currentName;
                        }
                        counter++;
                    }
                }
                pow ++;
            }

        }
    }