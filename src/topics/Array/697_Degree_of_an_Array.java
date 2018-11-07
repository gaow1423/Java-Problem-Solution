/*
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:

Input: [1, 2, 2, 3, 1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:

Input: [1,2,2,3,1,4,2]
Output: 6
Note:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.

*/
class Solution {
    public int findShortestSubArray(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        Map<Integer, int[]> map = new HashMap<> ();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new int[]{1, i, i});
            }
            else{
                int[] k = map.get(nums[i]);
                k[0]++;
                k[2] = i;
                map.put(nums[i], k);
            }
        }
        int degree = Integer.MIN_VALUE;
        int res = Integer.MAX_VALUE;
       
        for(int[] n : map.values()){
            if(n[0] > degree){
                degree = n[0];
                res = n[2] - n[1] + 1;
            }
            else if(n[0] == degree){
                res = Math.min(res, n[2] - n[1] + 1);
            }
        }
        return res;
    }
}