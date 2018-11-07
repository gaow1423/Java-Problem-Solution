/*
Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output:

2
Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output:

2
Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.

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
    private int len = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
        helper(root);
        return len;
    }
    public int helper(TreeNode node){
        if(node == null)
            return 0;
        int l = node.left != null ? helper(node.left) : 0;
        int r = node.right != null ? helper(node.right) : 0;
        int resl = node.left != null && node.val == node.left.val ? 1 + l : 0;
        int resr = node.right != null && node.val == node.right.val ? 1 + r : 0;
        len = Math.max(len, resl + resr);
        return Math.max(resl , resr);
    }
}