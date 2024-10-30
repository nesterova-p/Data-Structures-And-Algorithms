package Lab_1_SortingAndHeap.QuickSort;

public class QuickSort_v2 {
    public static void sort(int[] array, int start, int end){
        if (array == null) return;
        if(end <= start) return; // base case
        int pivot = partition(array, start, end);
        sort(array, start, pivot - 1);
        sort(array, pivot + 1, end);
    }

    public static void sort(int[] array){
        if (array == null) return;
        sort(array, 0, array.length - 1);
    }

    public static int partition(int[] array, int start, int end){
        int pivot = array[end];
        int i = start - 1;
        for(int j = start; j <= end - 1; j++){
            if(array[j] < pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;
        return i;
    }
}
