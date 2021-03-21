package softuni.advanced.algorithms_basics;

public class QuickSort {
    public static void main(String[] args) {

        int[] array = {1, 3, 1, 2, 5, 2, 1, 3};

        // output  1, 1, 1, 2, 2, 3, 3, 5

        quickSort(array, 0, array.length - 1);

        printArray(array);

    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = array[(left + right) / 2];
        int index = partitision(array, left, right, pivot);

        quickSort(array, left, index - 1);
        quickSort(array, index, right);
    }

    private static int partitision(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }

            while (array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] array, int left, int right) {
        int temporary = array[left];
        array[left] = array[right];
        array[right] = temporary;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
