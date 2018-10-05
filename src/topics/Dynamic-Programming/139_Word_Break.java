/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
*/

//dp[i] represents whether s[0...i] can be formed by dict boolean[] dp = new boolean[n] 
//dp[i] represents whether s[0...i] can be segmented into a space-separated sequence of one or more dictionary words.
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return false;
        int n = s.length();
        boolean[] dp = new boolean[n];
        for(int i = 0; i < n; i++){
        	for(int j = 0; j <= i; j++){
        		String sub = s.substring(j, i + 1);
        		if(wordDict.contains(sub) && (j == 0 || dp[j-1])){
        			dp[i] = true;
        			break;
        		}
        	}
        }
        return dp[n - 1];
    }
}