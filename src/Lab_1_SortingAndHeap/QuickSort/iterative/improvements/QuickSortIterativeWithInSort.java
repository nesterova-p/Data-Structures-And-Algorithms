package Lab_1_SortingAndHeap.QuickSort.iterative.improvements;

import Lab_1_SortingAndHeap.services.Sorting;

import static java.util.Objects.isNull;

public class QuickSortIterativeWithInSort<T extends Comparable<T>> implements Sorting<T> {

    private final int insertionSortThreshold;

    public QuickSortIterativeWithInSort(int insertionSortThreshold) {
        if (insertionSortThreshold < 1) {
            throw new IllegalArgumentException("Threshold must be greater than zero.");
        }
        this.insertionSortThreshold = insertionSortThreshold;
    }

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
            int high = stack[top--];
            int low = stack[top--];

            if (high - low < insertionSortThreshold) {
                //System.out.println("Using insertion sort for range: " + low + " to " + high);
                insertionSort(array, low, high);
                continue;
            }

            int pivotIndex = splitData(array, low, high);

            if (pivotIndex - 1 > low) {
                stack[++top] = low;
                stack[++top] = pivotIndex - 1;
            }

            if (pivotIndex + 1 < high) {
                stack[++top] = pivotIndex + 1;
                stack[++top] = high;
            }
        }
    }

    private void insertionSort(T[] array, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            T key = array[i];
            int j = i - 1;
            while (j >= low && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    private int splitData(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
