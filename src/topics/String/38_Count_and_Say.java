/*
   The count-and-say sequence is the sequence of integers with the first five terms as following:

   1.     1
   2.     11
   3.     21
   4.     1211
   5.     111221
   1 is read off as "one 1" or 11.
   11 is read off as "two 1s" or 21.
   21 is read off as "one 2, then one 1" or 1211.
   Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.
 */

class Solution {
	public String countAndSay(int n) {
		if( n == 1){
			return "1";
		}
		final String s = countAndSay(n - 1);
		StringBuilder res = new StringBuilder();
		int count = 0;
		char say = s.charAt(0);
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c == say){
				count += 1; 
			}
			else{
				res.append(count).append(say);
				say = c;
				count = 1;
			}	
		}
		res.append(count).append(say);
		return res.toString();
	}
}
