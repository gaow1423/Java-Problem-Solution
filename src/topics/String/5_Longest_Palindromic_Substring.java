/*
   Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

   Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

 */
public class Solution {
	private int low;
	private int max = 0;
	public String longestPalindrome(String s) {
		if(s.length() < 2){
			return s;
		}
		for(int i = 0; i < s.length(); i++){
			helper(s, i, i);//check the substring with even length
			helper(s, i, i+1);//check the substring with odd length
		}
		return s.substring(low, low + max);
	}
	public void helper(String s, int l, int h){
		while(l >= 0 && h < s.length() && s.charAt(l) == s.charAt(h)){
			l--;
			h++;
		}
		if(max < h - l - 1){
			low = l + 1;
			max = h - l - 1;
		}
	}
	
}
