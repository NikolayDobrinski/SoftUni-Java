package codewars.chalenges;

public class HighestandLowest {
        public static String highAndLow(String numbers) {

            String [] numberss = numbers.split(" ");
            int [] number = new int [numberss.length];

            for (int i = 0; i < number.length ; i++) {
                number[i] = Integer.parseInt(numberss[i]);
            }
            int highest = Integer.MIN_VALUE;
            int lowest = Integer.MAX_VALUE;

            for (int i = 0; i < number.length ; i++) {
                if (number[i] > highest){
                    highest = number[i];
                }
            }
            for (int i = 0; i < number.length ; i++) {
                if (number[i] < lowest){
                    lowest = number[i];
                }
            }
            String output = "" + highest + " " + lowest;

            return output;
        }
    }

