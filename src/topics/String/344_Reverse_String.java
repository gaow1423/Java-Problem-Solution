/*
Write a function that takes a string as input and returns the string reversed.

Example 1:

Input: "hello"
Output: "olleh"
Example 2:

Input: "A man, a plan, a canal: Panama"
Output: "amanaP :lanac a ,nalp a ,nam A"

*/

class Solution {
	public String reverseString(String s) {
		if(s.length() == 0) return s;
		char[] str = s.toCharArray();
		int l = 0;
		int h = s.length() - 1;
		while(l <= h){
			char temp;
			temp = str[l];
			str[l] = str[h];
			str[h] = temp;
			l++;
			h--;
		}
		return String.valueOf(str);       
    	}
}
