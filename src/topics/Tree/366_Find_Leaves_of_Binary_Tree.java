/*
Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

 

Example:

Input: [1,2,3,4,5]
  
          1
         / \
        2   3
       / \     
      4   5    

Output: [[4,5,3],[2],[1]]
 

Explanation:

1. Removing the leaves [4,5,3] would result in this tree:

          1
         / 
        2          
 

2. Now removing the leaf [2] would result in this tree:

          1          
 

3. Now removing the leaf [1] would result in the empty tree:

          []         
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

//bottom up method
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        if(root == null)
        	return res;
        helper(root, res);
        return res;
    }
    public int helper(TreeNode root, List<List<Integer>> res){
    	if(root == null)
    		return -1;
    	int level = 1 + Math.max(helper(root.left, res), helper(root.right, res));
    	if(res.size() < level + 1){
    		res.add(new ArrayList<Integer>());
    	}
    	res.get(level).add(root.val);
    	return level;
    }
}