/*
Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:
Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].
Note:
*/
class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        result = 0;
        for(int i = 0; i < A.size(); i++){
        	for (int j = 0; j < B.size(); j++){
        		// 最后一位不相等，dp[i][j]保持为0

        		if(A[i] != B[j])
        			continue;
        		// 最后一位相等
	// 如果i和j有一个是第一个数，dp[i][j] 肯定是1。

        		if(i == 0 || j == 0){
        			dp[i][j] = 1;
        			// dp[i][j] 表示，以A[i]和B[j]结尾的，最长公共子串的长度。

        		}else{
        			dp[i][j] = dp[i-1][j-1] + 1;
        		}
        		result = Integer.max(result, dp[i][j]);
        	}
        }
        return result;
    }
}