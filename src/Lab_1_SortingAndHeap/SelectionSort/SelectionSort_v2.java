package Lab_1_SortingAndHeap.SelectionSort;

public class SelectionSort_v2 {
    public static void sort(int[] array){
        if (array == null) return;
        for(int i = 0; i < array.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < array.length; j++){
                if (array[j] < array[min]){
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
}



