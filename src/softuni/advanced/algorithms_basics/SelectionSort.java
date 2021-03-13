package softuni.advanced.algorithms_basics;

//Description:
// |                         |                         |                         |
// 2, 8, 5, 3, 9, 4, 1 -> 1, 8, 5, 3, 9, 4, 2 -> 1, 2, 5, 3, 9, 4, 8 -> 1, 2, 3, 5, 9, 4, 8 ->
//             |                         |
// 1, 2, 3, 4, 9, 5, 8 -> 1, 2, 3, 4, 5, 9, 8 -> 1, 2, 3, 4, 5, 8, 9 -> sorted

public class SelectionSort {
    public static void main(String[] args) {

        int[] array = {2, 8, 5, 3, 9, 4, 1};

        selectionSort(array);
    }

    private static void selectionSort(int[] array) {

        for (int j = 0; j < array.length - 1; j++) {
            int currentMin = array[j]; //2 - first element
            int index = -1;
            for (int i = j + 1; i < array.length; i++) {
                if (array[i] < currentMin) {
                    currentMin = array[i]; //new current minimum
                    index = i;
                }
            }

            if (currentMin != array[j]) {
                // swap current item with current minimum
                int current = array[j];
                array[j] = currentMin;
                array[index] = current;
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}


