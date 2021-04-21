package softuni.fundamentals.arrays;

/**
 * Description:
 * You are given an array of integers representing coordinates of obstacles situated on a straight line.
 * Assume that you are jumping from the point with coordinate 0 to the right. You are allowed only to
 * make jumps of the same length represented by some integer.
 * Find the minimal length of the jump enough to avoid all the obstacles.
 * Example:
 * For inputArray = [5, 3, 6, 7, 9], the output should be
 * avoidObstacles(inputArray) = 4.
 *
 * Tests: [5, 3, 6, 7, 9] - 4
 * [2, 3] - 4
 * [1, 4, 10, 6, 2] - 7
 * [1000, 999] - 6
 * [19, 32, 11, 23] - 3
 * [5, 8, 9, 13, 14] - 6
 */

public class AvoidObstacles {
    public static void main(String[] args) {

        int[] array = new int[]{1000, 999};
        
        int jump = 2;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= 1000; j+=jump) {
                if (array[i] == j) {
                    jump++;
                    j = 0;
                    i = -1;
                    break;
                }
            }
        }
        System.out.println(jump);
    }
}
