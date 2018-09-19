import java.util.Map;

/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.
*/

class Solution {
   public boolean isStrobogrammatic(String num) {
    if(num == null) return true;
    Map<Integer, Integer> map = new HashMap<> ();
    map.put(6, 9);
    map.put(9, 6);
    map.put(8, 8);
    map.put(1, 1);
    map.put(0, 0);
    int s = 0;
    int e = num.length() - 1;
    while(s <= e){
        int start = num.charAt(s) - '0';
        int end = num.charAt(e) - '0';
        if(map.containsKey(start) && map.get(start) == end){
            s++;
            e--;
        }
        else{
            return false;
        }
    }
    return true;

    } 
}