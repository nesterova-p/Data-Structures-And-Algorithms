package Lab_1_SortingAndHeap.InsertionSort;

public class InsertionSort_v2 {
    public static void sort(int[] array){
        if (array == null) return;
        for(int i = 1; i < array.length; i++){
            int j = i - 1;
            int temp = array[i];
            while (j >= 0 && array[j] > temp){
                array[j+1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }
}
