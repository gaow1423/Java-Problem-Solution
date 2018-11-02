/*
Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].
*/

class Solution {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if(m == 0 || n == 0)
            return 0;
        int dp[][] = new int [m+1][n+1];
        int max = 0;
        for(int i = m-1; i >= 0; i--){
        	for(int j = n-1; j >= 0; j--){
                dp[i][j] = A[i] == B[j] ? dp[i+1][j+1] + 1 : 0;
        		max = Math.max(max, dp[i][j]);
        	}
        }
        // for(int i = 1; i < m; i++){
        // 	for(int j = 1; j < n; j++){
        // 		dp[i][j] = A[i] == B[j] ? dp[i-1][j-1] + 1 : 0;
        // 		max = Math.max(max, dp[i][j]);
        // 	}
        // }
        return max;
    }
}