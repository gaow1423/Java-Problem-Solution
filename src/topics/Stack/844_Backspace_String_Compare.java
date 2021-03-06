/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
*/
class Solution {
    public boolean backspaceCompare(String S, String T) {
        String a = helper(S);
        String b = helper(T);
        return a.equals(b);
    }
    public String helper(String s){
    	Stack<Character> stack = new Stack<> ();
    	StringBuilder sb = new StringBuilder();
    	int i = 0;
    	while(i < s.length()){
    		if(s.charAt(i) == '#'){
    			if(!stack.isEmpty())
    				stack.pop();
    		}
    		else{
    			stack.push(s.charAt(i));
    		}
    		i++;
    	}
    	while(!stack.isEmpty()){
    		sb.append(stack.pop());
    	}
    	return sb.reverse().toString();
    }
}