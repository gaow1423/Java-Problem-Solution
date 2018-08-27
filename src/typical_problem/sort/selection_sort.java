//running time O(n^2)
class Solution{
    public static void main(String[] args){
        int[] myArray = selectionSort(new int[] {9, 8, 13, 87, 12, 99});
        for(int i = 0; i < myArray.length; i++){
            System.out.println(myArray[i]);
        }
    }
    public static int [] selectionSort(int a[]){
        
        for(int i = 0; i < a.length; i++){
            int min = i;
            for(int j = i + 1; j < a.length; j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        return a;
    }
}