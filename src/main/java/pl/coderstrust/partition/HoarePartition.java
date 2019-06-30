package pl.coderstrust.partition;

import java.util.Arrays;

public class HoarePartition {

    public static void main(String[] args) {
        int[] array = new int[]{1, 7, 9, 4, 3, 2, 8, 5, 4, 10, 5, 9, 11, 34, 2, 1, 9, 44, 4};
        try {
            partition(array, 10);
            System.out.println("Partition result is: " + Arrays.toString(array));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void partition(int[] array, int pivotIndex) {
        if (pivotIndex > array.length) {
            throw new IndexOutOfBoundsException("Given pivot index cannot exceed length of array");
        }
        if (array.length < 2) {
            return;
        }
        int start = 0;
        int end = array.length - 1;
        int pivot = array[pivotIndex];
        swap(array, start, pivotIndex);
        start++;
        int lastLowerIndex = start;
        do {
            while (array[start] <= pivot) {
                lastLowerIndex = start;
                start++;
                if (start == array.length) {
                    break;
                }
            }
            while (array[end] > pivot) {
                end--;
                if (end < 0) {
                    break;
                }
            }
            if (start <= end) {
                swap(array, start, end);
                lastLowerIndex = start;
                start++;
                end--;
            }
        } while (start <= end);
        if (array[lastLowerIndex] <= array[0]) {
            swap(array, 0, lastLowerIndex);
        }
    }

    private static void swap(int[] array, int s, int e) {
        int temp = array[s];
        array[s] = array[e];
        array[e] = temp;
    }
}
