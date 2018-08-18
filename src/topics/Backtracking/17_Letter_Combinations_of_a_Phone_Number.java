/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

class Solution {
    public List<String> letterCombinations(String digits) {
  	LinkedList<String> ans = new LinkedList<String>();
	if(digits.isEmpty()) return ans;
	String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	ans.add("");
	for(int i = 0; i < digits.length(); i++){
		int x = digits.charAt(i) - '0';//convert each digit in input into number
		while(ans.peek().length() == i){//when the length of the head is equal to to i;
			String t = ans.remove();//remove the head, and return the head.
			for(char s : mapping[x].toCharArray())
				ans.add(t+s);
		}
	}
	return ans;      
    }
}
