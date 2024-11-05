import java.lang.reflect.Array;
import Lab_1_SortingAndHeap.services.Sorting;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class GeneralSortTest<T extends Comparable<T>> {

    protected Sorting<T> sorter;
    public GeneralSortTest(Sorting<T> sorter) {
        this.sorter = sorter;
    }

    @Test
    public void sortArray() {
        // given
        T[] nums = (T[]) new Integer[]{5, 32, 50, 69, 18, 71, 47};

        // when
        sorter.sort(nums);

        // then
        assertTrue(isSorted(nums));
    }

    @Test
    public void sortOneElementArray() {
        // given
        T[] nums = (T[]) new Integer[]{39};

        // when
        sorter.sort(nums);

        // then
        assertTrue(isSorted(nums));
    }

    @Test
    public void sortTwoElementArray() {
        // given
        T[] nums = (T[]) new Integer[]{3, 1};

        // when
        sorter.sort(nums);

        // then
        assertTrue(isSorted(nums));
    }

    @Test
    public void sortThreeElementArray() {
        // given
        T[] nums = (T[]) new Integer[]{3, 1, 39};

        // when
        sorter.sort(nums);

        // then
        assertTrue(isSorted(nums));
    }

    @Test
    public void should_CorrectlyAscendingSort_When_InputIsRandomAndHuge() {
        // given
        int size = 10_000;
        T[] nums = (T[]) Generators.createRandomData(size);
        T[] numsCopy = nums.clone();

        // when
        sorter.sort(nums);

        // then
        assertTrue(isSorted(nums));
        assertArrayEquals(numsCopy, nums);
    }

    @Test
    public void should_ReturnEmptyArray_When_InputIsEmpty() {
        // given
        T[] nums = (T[]) Array.newInstance(Double.class, 0);

        // when
        sorter.sort(nums);

        // then
        assertEquals(0, nums.length);
    }

    @Test
    public void should_ThrowException_When_InputIsNull() {
        // given
        T[] nums = null;

        // when & then
        Exception exception = assertThrows(RuntimeException.class, () -> sorter.sort(nums));
        assertEquals("Input args (data) cannot be null!", exception.getMessage());
    }

    @Test
    public void should_CorrectlySort_When_OnlyFirstIsWrong() {
        // given
        T[] nums = (T[]) new Integer[]{5, 1, 2, 3, 4};

        // when
        sorter.sort(nums);

        // then
        assertTrue(isSorted(nums));
    }

    @Test
    public void should_CorrectlySort_When_OnlyLastIsWrong() {
        // given
        T[] nums = (T[]) new Integer[]{1, 2, 3, 4, 0};

        // when
        sorter.sort(nums);

        // then
        assertTrue(isSorted(nums));
    }

    @Test
    public void should_CorrectlySort_When_UnsortedSizeIsEven() {
        // given
        T[] nums = (T[]) new Integer[]{2, 1, 4, 3};

        // when
        sorter.sort(nums);

        // then
        assertTrue(isSorted(nums));
    }

    @Test
    public void should_CorrectlySort_When_UnsortedSizeIsOdd() {
        // given
        T[] nums = (T[]) new Integer[]{4, 2, 5, 3, 1};

        // when
        sorter.sort(nums);

        // then
        assertTrue(isSorted(nums));
    }

    @Test
    public void sortDuplicateOneValueArray() {
        // given
        T[] nums = (T[]) new Integer[]{9, 6, 4, 9, 5};

        // when
        sorter.sort(nums);

        // then
        assertTrue(isSorted(nums));
    }

    @Test
    public void sortDuplicateValuesArray() {
        // given
        T[] nums = (T[]) new Integer[]{3, 3, 3, 3, 3};

        // when
        sorter.sort(nums);

        // then
        assertTrue(isSorted(nums));
    }

    private boolean isSorted(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}
