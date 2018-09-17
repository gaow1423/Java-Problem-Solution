/*
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
Seen this question in a real interview before?  YesNo

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
    	return helper(root, k, new HashMap<Integer, Integer>());	    
    }
    public boolean helper(TreeNode root, int k, HashMap<Integer, Integer> map){
    	if(root == null)
    		return false;
    	if(map.containsKey(k - root.val))
    		return true;
    	map.put(root.val, 0);
    	return helper(root.left, k, map)||helper(root.right, k, map);
    }
}











