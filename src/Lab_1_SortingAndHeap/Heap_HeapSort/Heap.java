package Lab_1_SortingAndHeap.Heap_HeapSort;

import java.util.ArrayList;
import java.util.Collections;

public class Heap<T extends Comparable<T>> {
    private ArrayList<T> heap;

    Heap(){
        heap = new ArrayList<>();
    }

    public void insert(T value){
        if (value == null) throw new IllegalArgumentException("Value cannot be null");
        heap.add(value);
        int index = heap.size() - 1;
        heapifyUp(index);
    }

    private void heapifyUp(int index) {
        int indexParent = (index - 1) / 2;
        if (index == 0 ) return; // base case
        T current = heap.get(index);
        T parent = heap.get(indexParent);
        if(current.compareTo(parent) > 0){
            Collections.swap(heap,index,indexParent);
            heapifyUp(indexParent);
        }
    }

    private void heapifyDown(int index){
        int large = index;
        int left = 2*index + 1;
        int right = 2*index + 2;

        if (left < heap.size() && heap.get(left).compareTo(heap.get(large)) > 0) {
            large = left;
        }
        if (right < heap.size() && heap.get(right).compareTo(heap.get(large)) > 0) {
            large = right;
        }

        if(large != index){
            Collections.swap(heap, index, large);
            heapifyDown(large);
        }
    }

    public int size(){
        return heap.size();
    }

    public T peek(){
        if(heap.isEmpty()) return null;
        return heap.get(0);
    }

    public T extractMax(){
        if (heap.isEmpty()) return null;
        Collections.swap(heap, 0, heap.size() - 1);
        T max = heap.remove(heap.size()-1);
        heapifyDown(0);
        return max;
    }
}
