package Lab_1_SortingAndHeap.QuickSort.iterative.improvements;

import Lab_1_SortingAndHeap.services.Sorting;

import static java.util.Objects.isNull;

public class QuickSortIterativeMedian3<T extends Comparable<T>> implements Sorting<T> {

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

    private void quicksort(T[] nums) {
        int[] stack = new int[nums.length];
        int top = -1;

        stack[++top] = 0;
        stack[++top] = nums.length - 1;

        while (top >= 0) {
            int end = stack[top--];
            int low = stack[top--];

            int pivotIndex = splitData(nums, low, end);

            if (pivotIndex - 1 > low) {
                stack[++top] = low;
                stack[++top] = pivotIndex - 1;
            }

            if (pivotIndex < end) {
                stack[++top] = pivotIndex;
                stack[++top] = end;
            }
        }
    }

    private int splitData(T[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        T pivot = medianOfThree(nums, start, mid, end);

        while (start <= end) {
            while (nums[start].compareTo(pivot) < 0) {
                start++;
            }
            while (nums[end].compareTo(pivot) > 0) {
                end--;
            }
            if (start <= end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private T medianOfThree(T[] nums, int start, int mid, int end) {
        if (nums[start].compareTo(nums[mid]) > 0) {
            swap(nums, start, mid);
        }
        if (nums[start].compareTo(nums[end]) > 0) {
            swap(nums, start, end);
        }
        if (nums[mid].compareTo(nums[end]) > 0) {
            swap(nums, mid, end);
        }
        return nums[mid];
    }

    private void swap(T[] nums, int i, int j) {
        T temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
