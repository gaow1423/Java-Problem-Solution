class Solution{
    public static void main(String[] args){
        int[] inputArray = {9, 7, 3, 1, 6, 3, 2, 6, 8, 9, 2, 3, 0};
        sort(inputArray, 0, inputArray.length - 1);
        // MergeSort sorter = new MergeSort();
        // sorter.sort(inputArray);
        for (int i = 0; i < inputArray.length; i++){
            System.out.println(inputArray[i]);
        }
    }
    public static void sort(int inputArray[], int start, int end){
        if(end <= start){
            return;
        }
        int mid = (start + end)/2;
        sort(inputArray, start, mid);//sort left half
        sort(inputArray, mid + 1, end);//sort right half
        merge(inputArray, start, mid, end);//merge sorted results into the inputArray
    }
    public static void merge(int inputArray[], int start, int mid, int end){
        int[] temp = new int[end - start + 1];
        int leftindex = start;
        int rightindex = mid + 1;
        int k = 0;
        while(leftindex <= mid && rightindex <= end){
            if(inputArray[leftindex] <= inputArray[rightindex]){
                temp[k] = inputArray[leftindex];
                leftindex++;
            }
            else{
                temp[k] = inputArray[rightindex];
                rightindex++;
            }
            k++;
        }
        /**
         * When it get's to here, that means the above loop has completed.
         * so both the right and the left side of the sub-array can be considered sorted
         */
        if(leftindex <= mid){
            while(leftindex <= mid){
                temp[k] = inputArray[leftindex];
                leftindex ++;
                k++;
            }
        }
        else if(rightindex <= end){
            while(rightindex <= end){
                temp[k] = inputArray[rightindex];
                rightindex ++;
                k++;
            }
        }
        for(int i = 0; i < temp.length; i++){
            inputArray[start + i] = temp[i];
        }
    }
}