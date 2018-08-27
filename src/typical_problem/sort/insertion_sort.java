//running time: O(n^2)
class Solution{
    public static void main(String [] args){
        int myArray[] = insertionSort(new int[] {9, 8, 99, 110, 8, 87, 637, 8, 3, 13, 87, 12, 99});
        for(int i : myArray){
            System.out.println(i);
        }
    }
    
    public static int[] insertionSort(int [] a){
        for(int i = 1; i < a.length; i++){
            int element = a[i];
            int j = i - 1;
            while(j >= 0 && a[j] > element){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = element;
        }
        return a;
    }
}