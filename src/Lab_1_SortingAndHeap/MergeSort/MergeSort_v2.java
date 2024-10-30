package Lab_1_SortingAndHeap.MergeSort;

public class MergeSort_v2 {
    public static void sort(int[] array){
        if (array == null) return;
        int length = array.length;
        int middle = length / 2;
        if (length <= 1) return; // base case
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];
        int i = 0, j = 0; // i for left array, j - right array
        for(; i < length; i++){
            if (i < middle){
                leftArray[i] = array[i];
            }
            else {
                rightArray[j] = array[i];
                j++;
            }
        }
        sort(leftArray);
        sort(rightArray);
        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = array.length/2;
        int rightSize = array.length - leftSize;
        int i = 0; // original array
        int l = 0, r = 0; // left and right array
        while (l < leftSize && r < rightSize){
            if(leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else{
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while (l < leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightSize){
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
}
