/*
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int r = 0;
        if(nums.length < 3)
            return -1;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int t = target - nums[i];
            int l = i + 1;
            int h = nums.length - 1;
            while(l < h){
                int res = nums[l] + nums[h];
                if(Math.abs(res - t) <= min){
                    // System.out.println(nums[i]);
                    // System.out.println(res);
                    min = Math.abs(res - t);
                    r = res + nums[i];
                }
                if(res > t)
                    h--;
                else if(res < t)
                    l++;
                else
                    return target;
            }    
        }
        return r;
    }
}