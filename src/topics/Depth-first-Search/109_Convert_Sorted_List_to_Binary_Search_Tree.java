/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
         if(head == null)
        	return null;
        
        return helper(head, null);
    }
    public TreeNode helper(ListNode head, ListNode tail){
    	ListNode n1 = head;
    	ListNode n2 = head;
        if(head == tail) return null;
    	while(n2 != tail && n2.next != tail){
    		n1 = n1.next;
    		n2 = n2.next.next;
    	}
    	TreeNode node = new TreeNode(n1.val);

    	node.left = helper(head, n1);
    	node.right = helper(n1.next, tail);
    	return node;
    }
}