/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    if(head == null || head.next == null) return;
    //Find the middle of the list
    ListNode p1 = head;
    ListNode p2 = head;
    while(p2.next != null && p2.next.next != null){
        p1 = p1.next;
        p2 = p2.next.next;
    }
    //1, 2, 3, 4, 5, 6, p1 is 3 and p2 is 5;
    ListNode middle = p1;
    ListNode prev = null;
    ListNode cur = p1.next;
    ListNode next = null;
    while(cur != null){
        next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
    }
    p1.next = prev;

    //1, 2, 3, 6, 5, 4
    p1 = head;
    p2 = middle.next;
    while(p1 != middle){
        middle.next = p2.next;
        next = p1.next;
        p1.next = p2;
        p2.next = next;
        p1 = p2.next;
        p2 = middle.next;
    }
}