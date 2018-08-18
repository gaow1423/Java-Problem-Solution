/*
   Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

   The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
[7],
[2, 2, 3]
]
 */

class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		helper(res, new ArrayList<Integer>(), candidates, target, 0);
		return res;
	}
	public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int target, int start){
		if (target < 0) return;
		else if(target == 0){
			res.add(new ArrayList<Integer>(list));
		}       
		else
		{
			for(int i = start; i < nums.length; i++){
				list.add(nums[i]);
				helper(res, list, nums, target - nums[i], i);
				list.remove(list.size()-1);
			}
		}
	}
}
/*
Note:
In this question, the elements can be used again, so, in helper function we use i instead of i+1;
*/
