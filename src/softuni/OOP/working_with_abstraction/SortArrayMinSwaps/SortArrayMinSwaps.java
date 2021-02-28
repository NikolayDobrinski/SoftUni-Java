package softuni.OOP.working_with_abstraction.SortArrayMinSwaps;

import java.util.HashMap;
import java.util.Map;

public class SortArrayMinSwaps {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 4, 3, 2};

        int moves = countMoves(arr);

        System.out.println(moves);
    }

    private static int countMoves(int[] arr) {
        boolean[] isVisited = new boolean[arr.length + 1];
        Map<Integer, Integer> nodeMap = new HashMap<>();

        for (int i = 1; i < isVisited.length; i++) {
            nodeMap.put(i, arr[i - 1]);
        }
        int countSwap = 0;

        for (int k = 1; k <= nodeMap.size(); k++) {
            int nextNode;

            if (isVisited[k] == false) {
                isVisited[k] = true;

                if (k == nodeMap.get(k)) {
                    continue;
                } else {
                    int c = nodeMap.get(k);

                    while (!isVisited[c]) {
                        isVisited[c] = true;
                        nextNode = nodeMap.get(c);
                        c = nextNode;
                        ++countSwap;
                    }
                }
            }
        }

        return countSwap;
    }
}
