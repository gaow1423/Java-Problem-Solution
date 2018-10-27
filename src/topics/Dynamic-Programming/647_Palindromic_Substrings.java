/*
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
*/

class Solution {
    boolean dp[][];
    boolean hasDone[][];
    String s;
    public int countSubstrings(String s) {
        // Dp[i][j] 表示 从s[i]到s[j] 是否是回文。
        dp = new boolean[s.length()][s.length()];
        hasDone = new boolean[s.length()][s.length()];
        this.s = s;
        
        int result = 0;
        for (int i = 0; i < s.length(); i++)
           for (int j = i; j < s.length(); j++)
	   if (getDp(i, j))
		result += 1;
        return result;
    }
// Dp[i][j] 表示 从s[i]到s[j] 是否是回文。
//   Dp[i][j] = dp[i+1][j-1] && s[i] == s[j];  

    public boolean getDp(int i, int j) {
//one length or empty
	if (i >= j)
		return true;
	if (s.charAt(i) != s.charAt(j))
		return false;

	if (hasDone[i][j])
		return dp[i][j];
	//getDp(i+1,j-1) 就可以看作是dp[i+1][j-1];
	dp[i][j] = getDp(i+1, j-1);
	hasDone[i][j] = true;
	return dp[i][j];
   }
}