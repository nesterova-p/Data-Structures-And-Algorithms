package Lab_1_SortingAndHeap.RefAlgSort;

import Lab_1_SortingAndHeap.services.Sorting;

import java.util.Arrays;
import static java.util.Objects.isNull;

public class RefAlgSort<T extends Comparable<T>> implements Sorting<T> {

    @Override
    public void sort(T[] data) {
        validateInput(data);

        Arrays.sort(data);
    }

    private void validateInput(T[] data) {
        if (isNull(data)) {
            throw new RuntimeException("Input args (data) cannot be null!");
        }
    }
}
