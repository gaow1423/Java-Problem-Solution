/*
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
For example:
Given BST [1,null,2,2],

   1
    \
     2
    /
   2
 

return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
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
    private Map<Integer, Integer> map;
    private int max;
    public int[] findMode(TreeNode root) {
        map = new HashMap<> ();
        max = -1;
        if(root == null){
            return new int[0];
        }
        inorder(root);
        List<Integer> list = new ArrayList<> ();
        for(Integer k : map.keySet()){
            if(max == map.get(k))
                list.add(k);
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
        
    }
    public void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        max = Math.max(max, map.get(root.val));
        inorder(root.right);
    }
}