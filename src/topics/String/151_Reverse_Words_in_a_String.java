/*
   Given an input string, reverse the string word by word.

Example:  

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
Follow up: For C programmers, try to solve it in-place in O(1) space.
 */

public class Solution {
	public String reverseWords(String s) {
		s.trim();
		if(s.length() == 0) return null;
		String[] str = s.split(" +");
		
		StringBuilder res = new StringBuilder();
		for(int i = str.length - 1; i >= 0; i--){
			res.append(str[i]).append(" ");
		}
		return res.toString().trim();
	}
}

//alternative approach:
public class Solution {
	public String reverseWords(String s){
		if(s == null || s.length() == 0) return s;
		StringBuilder sb = new StringBuilder();
		s = s.trim();
		if(s.length() == 0) return "";
		int end = s.length() - 1;
		while(end >= 0){
			while(s.charAt(end) == ' '){
				end --;
			}
			int spacidx = s.lastIndexOf(" ", end);
			String word = s.substring(spacidx + 1, end + 1);
			if(sb.length() != 0){
				sb.append(" ");
			}
			sb.append(word);
			end = spacidx - 1;
		}
		return sb.toString();
	}
}
