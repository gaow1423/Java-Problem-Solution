/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 //iterative method
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        return head;
    }
}

//recursive method
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode prev = null;
//         ListNode next = null;
//         ListNode cur = head;
//         helper(prev, cur);
//         return prev;
//     }
//     public void helper( ListNode prev,  ListNode cur){
//         if(cur == null) return;
//         ListNode next = cur.next;
//         cur.next = prev;
//         prev = cur;
//         cur = next;
//         helper(cur,  next);
//     }
// }

Public Static Node reverse(Node node){
    if(node.next == null)
        return node;
    Node ret = reverse(node.next);
    node.next.next = node;
    node.next = null;
    return ret;
}