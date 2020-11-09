package codewars.chalenges;

public class EqualSidesOfAnArray {

    public static int findEvenIndex(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int j = i - 1; j >= 0; j--) {
                leftSum += arr[j];
            }
            for (int j = i + 1; j < arr.length; j++) {
                rightSum += arr[j];
            }
            if (leftSum == rightSum) {
                int index = i;
                return index;

            }
        }
        int result = -1;
        return result;
    }
}
