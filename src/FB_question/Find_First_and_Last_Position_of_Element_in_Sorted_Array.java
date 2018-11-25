/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/

class Solution {
    
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 1){
            if(nums[0] == target)
                return new int[] {0, 0};
            else
                return new int[] {-1, -1};
        }
        int lo = 0;
        int hi = nums.length - 1;
        int found = 0;
        int mid = lo + (hi - lo) / 2;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] == target){
                found = 1;
                break;
            }
            else if(nums[mid] < target){
                lo = mid + 1;
            }
            else if(nums[mid] > target){
                hi = mid - 1;
            }
        }
        
        if(found == 0)
            return new int[] {-1, -1};
        else{
            int l = mid;
            int r = mid;
            while(l >= 0 && nums[l] == nums[mid]){
                l--;
            }
            while(r < nums.length && nums[r] == nums[mid]){
                r++;
            }
            return new int[] {l + 1, r - 1};
        }
    }
}