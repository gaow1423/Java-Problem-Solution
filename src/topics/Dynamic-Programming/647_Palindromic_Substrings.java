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
    public int countSubstrings(String s) {
         int sLen = s.length();
        char[] cArr = s.toCharArray();
        
        int totalPallindromes = 0;
        
        boolean[][] dp = new boolean[sLen][sLen];
        
        // Single length pallindroms
        for (int i = 0; i < sLen; i++) {
            dp[i][i] = true;
            totalPallindromes++;
        }
        
        // 2 length pallindromes
        for (int i = 0; i < sLen - 1; i++) {
            if (cArr[i] == cArr[i + 1]) {
                dp[i][i + 1] = true;
                totalPallindromes++;
            }
        }

        // Lengths > 3
        
        for (int subLen = 2; subLen < sLen; subLen++) {
            
            for (int i = 0; i < sLen - subLen; i++) {
                
                int j = i + subLen;
                
                if (dp[i + 1][j - 1] && cArr[i] == cArr[j]) {
                    dp[i][j] = true;
                    totalPallindromes++;
                }
            }
        }        
        return totalPallindromes;
        
    }
}