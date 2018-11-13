/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<> ();
        Stack<Integer> s2 = new Stack<> ();
        ListNode l = l1;
        while(l != null){
            s1.add(l.val);
            l = l.next;
        }
        l = l2;
        while(l != null){
            s2.add(l.val);
            l = l.next;
        }
        ListNode l3 = null;
        ListNode cur = l3;
        int carry = 0;
        while(!s1.isEmpty() && !s2.isEmpty()){
            int res = s1.pop() + s2.pop() + carry;
            carry = res/10;
            res = res % 10;
            // System.out.println(carry);
            ListNode n = new ListNode(res);
            n.next = cur;
            cur = n;
        }
        
        while(!s1.isEmpty()){
            int res = carry + s1.pop();
            carry = res/10;
            res = res % 10;
            ListNode n = new ListNode(res);
            n.next = cur;
            cur = n;
        }
        while(!s2.isEmpty()){
            int res = carry + s2.pop();
            carry = res/10;
            res = res % 10;
            ListNode n = new ListNode(res);
            n.next = cur;
            cur = n;
        }
        
        if(s1.isEmpty() && s2.isEmpty() && carry != 0){
            ListNode n = new ListNode(carry);
            n.next = cur;
            cur = n;
        }
        
        return cur;
    }
}