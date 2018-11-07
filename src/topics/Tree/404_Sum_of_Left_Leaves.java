/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
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
    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root, false);
        return sum;
    }
    public void helper(TreeNode root, boolean b){
        if(root == null)
            return;
        if(root.left == null && root.right == null && b == true){
            sum += root.val;
            return;
        }
        helper(root.left, true);
        helper(root.right, false);
    }
}