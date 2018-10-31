/*
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
         List<List<Integer>> results = new LinkedList<List<Integer>>();
		if (num == null || num.length < 4)
			return results;
		Arrays.sort(num);

		for (int s = 0; s < num.length - 3; s++) {
			if (s > 0 && num[s] == num[s - 1]) 	continue;
			

			for (int e = num.length - 1; e >= s + 3; e--) {
				if (e < num.length - 1 && num[e] == num[e + 1]) continue;
				
				int local = target - num[s] - num[e];
				int j = s + 1;
				int k = e - 1;
				while (j < k) {

					if (j > s + 1 && num[j] == num[j - 1]) {
						j++;
						continue;
					}
					if (k < e - 1 && num[k] == num[k + 1]) {
						k--;
						continue;
					}

					if ((num[j] + num[k]) > local)
						k--;
					else if ((num[j] + num[k]) < local)
						j++;
					else
						results.add(new ArrayList<Integer>(Arrays.asList(
								num[s], num[j++], num[k--], num[e])));
				}
			}
		}
		return results;
    }
}