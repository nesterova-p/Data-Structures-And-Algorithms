package Lab_1_SortingAndHeap.QuickSort.iterative.improvements;

import Lab_1_SortingAndHeap.services.Sorting;

import java.util.Random;

import static java.util.Objects.isNull;

public class QuickSortIterativeRandom<T extends Comparable<T>> implements Sorting<T> {

    private final Random random = new Random();

    @Override
    public void sort(T[] nums) {
        validateInput(nums);
        if (nums.length == 0) {
            return; // Early return for empty arrays
        }
        quicksort(nums);
    }

    private void validateInput(T[] data) {
        if (isNull(data)) {
            throw new IllegalArgumentException("Input args (data) cannot be null!");
        }
    }

    private void quicksort(T[] array) {
        int[] stack = new int[array.length];
        int top = -1;

        stack[++top] = 0;
        stack[++top] = array.length - 1;

        while (top >= 0) {
            int end = stack[top--];
            int start = stack[top--];

            int pivotIndex = splitData(array, start, end);

            if (pivotIndex - 1 > start) {
                stack[++top] = start;
                stack[++top] = pivotIndex - 1;
            }

            if (pivotIndex + 1 < end) {
                stack[++top] = pivotIndex + 1;
                stack[++top] = end;
            }
        }
    }

    private int splitData(T[] array, int start, int end) {
        int pivotIndex = start + random.nextInt(end - start + 1);
        T pivot = array[pivotIndex];
        swap(array, pivotIndex, end);

        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, end);
        return i + 1;
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
