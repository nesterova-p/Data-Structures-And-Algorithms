package Lab_1_SortingAndHeap.SelectionSort;

import Lab_1_SortingAndHeap.services.Sorting;

import static java.util.Objects.isNull;

public class SelectionSort<T extends Comparable<T>> implements Sorting<T> {

    @Override
    public void sort(T[] data) {
        validateParams(data);

        int n = data.length;

        int minValId;

        for (int i = 0; i < n - 1; i++) {
            minValId = i;

            for (int j = i + 1; j < n; j++) {
                if (data[j].compareTo(data[minValId]) < 0) {
                    minValId = j;
                }
            }

            swap(data, i, minValId);
        }
    }

    private void validateParams(T[] data) {
        if (isNull(data)) {
            throw new RuntimeException("Input args (data) cannot be null!");
        }
    }

    private void swap(T[] data, int firstId, int secondId) {
        if (firstId != secondId) {
            T firstVal = data[firstId];
            data[firstId] = data[secondId];
            data[secondId] = firstVal;
        }
    }
}
