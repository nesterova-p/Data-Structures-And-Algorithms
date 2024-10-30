package Lab_1_SortingAndHeap.services;

public interface Sorting<T extends Comparable<T>> {

    void sort(T[] nums);
}
