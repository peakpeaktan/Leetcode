public class InsertionSort {
    //label_sort
    //label_array
    public static void insertionSort(int[] array){
        if(array.length == 1) return;
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            while(j>= 0 && array[j] > array[i]){//look from right to left(large to small)
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = array[i];
        }
    }

    public static void main(String[] args){
        int[] array = {6, 5, 3, 4, 7, 1};
        insertionSort(array);
    }
}
