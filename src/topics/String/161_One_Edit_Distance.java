/*
Given two strings s and t, determine if they are both one edit distance apart.

Note: 

There are 3 possiblities to satisify one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t
Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
Example 2:

Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.
Example 3:

Input: s = "1203", t = "1213"
Output: true
Explanation: We can replace '0' with '1' to get t.

*/

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length() - t.length()) > 1)
            return false;
        if(s.length() == t.length())
            return isModify(s, t);
        if(s.length() > t.length())
            return isDelete(s, t);
        return isDelete(t, s);
    }
    public boolean isModify(String s, String t){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i))
                count ++;
        }
        // if(count > 1)
        //     return false;
        // return true;
        return count == 1;
    }
    
    public boolean isDelete(String s, String t){
        for(int i=0,j=0;i<s.length() && j<t.length();i++,j++){
            if(s.charAt(i) != t.charAt(j)){
                return s.substring(i+1).equals(t.substring(j));
            }
        }
        
        return true;
    }
}