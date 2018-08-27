//the running time is O(nlgn).
import java.util.Arrays;
class Solution{
    public static void main(String[] args){
        int[] inputArray = {12, 81, 74, 43, 1098, 0, 8, 92, 17, 754, 912, 0, 6, 4};
        quickSort(inputArray, 0, inputArray.length - 1);
        System.out.println(Arrays.toString(inputArray));
    }
    public static void quickSort(int [] inputArray, int start, int end){
        if(start < end){
            int p = partition(inputArray, start, end);
            //the pivot is at the right place by order already.
            quickSort(inputArray, start, p - 1);
            quickSort(inputArray, p + 1, end);
        }
    }
    public static int partition(int [] inputArray, int start, int end){
        // int[] temp = new int[end - start + 1];
        int pivot = inputArray[end];
        int i = start - 1;
        for(int j = start; j <= end - 1; j++){
            if(inputArray[j] < pivot){
                i++;
                //swapping
                int buffer = inputArray[i];
                inputArray[i] = inputArray[j];
                inputArray[j] = buffer;
            }
        }
        int buffer = inputArray[i + 1];
        inputArray[i + 1] = pivot;
        inputArray[end] = buffer;
        return i+1;
    }
}