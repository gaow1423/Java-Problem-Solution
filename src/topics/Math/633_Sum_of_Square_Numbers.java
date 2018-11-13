/*
Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:
Input: 3
Output: False
*/

class Solution {
    public boolean judgeSquareSum(int c) {
        if(c < 0){
        	return false;
        }
        int start = 0;
        int end = (int) Math.sqrt(c);
        while(start <= end){
        	int res = start * start + end * end;
        	if(res < c)
        		start++;
        	else if(res > c)
        		end--;
        	else
        		return true;
        }
        return false;
    }
}