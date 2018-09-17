/*
Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

Example :

Input:  root = [5,1,5,5,5,null,5]

              5
             / \
            1   5
           / \   \
          5   5   5

Output: 4
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
	int count;
    public int countUnivalSubtrees(TreeNode root) {
    	count = 0;
    	helper(root);
    	return count;
    }
    boolean helper(TreeNode root){
    	if(root == null) return true;
    	boolean left = helper(root.left);
    	boolean right = helper(root.right);

    	if(left && right && (root.left == null || root.val == root.left.val) && (root.right == null || root.val == root.right.val)){
    		count++;
    		return true;
    	}
    	return false;
    }
}

class Solution {
    public int numJewelsInStones(String J, String S) {
    	char[] stones = S.toCharArray[];
    	int count = 0;
    	Map<Character, Integer> map = HashMap<Character, Integer> ();
    	for(char c ：stones){
    		map.put(c, map.getOrDefault(c, 0) + 1);
    	}
    	for(char c : J.toCharArray[]){
    		if(map.containsKey(c))
    			count += map.get(c);
    	}
    	return count;
    }
}











