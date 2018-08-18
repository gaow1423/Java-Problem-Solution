/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

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
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode first = new ListNode(0);
        ListNode d = first;
        int sum = 0;
        while (c1 != null || c2 != null){
            sum /=  10;
            if (c1 != null){
                sum = sum + c1.val;
                c1 = c1.next;
            }
            if (c2 != null){
                sum = sum + c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum/10 == 1)
        
            d.next = new ListNode(1);
        
        return first.next;
    }
}

/*
Mark: 
1. dont forget to allocate new node.
2. If there is a constructor, follow the format of constructor.
*/
