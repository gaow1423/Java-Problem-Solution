/*
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
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
    public ListNode sortList(ListNode head) {
    	if (head == null || head.next == null)
      return head;
 		ListNode pre = null;
 		ListNode slow = head, fast = head;
 		//cut the list into two halves.
 		while(fast != null && fast.next != null){
 			pre = slow;
 			slow = slow.next;
 			fast = fast.next.next;
 		}
 		pre.next = null;

 		//sort each half
 		ListNode l1 = sortList(head);
 		ListNode l2 = sortList(slow);

 		//merge l1 and l2
 		return merge(l1, l2);
    }
    ListNode merge(ListNode l1, ListNode l2){
    	ListNode l = new ListNode(0), p = l;
    	while(l1 != null && l2 != null){
    		if(l1.val < l2.val){
    			p.next = l1;
    			l1 = l1.next;
    		}
    		else{
    			p.next = l2;
    			l2 = l2.next;
    		}
    		p = p.next;
    	}
    	if(l1 != null)
    		p.next = l1;
    	if (l2 != null)
      		p.next = l2;
    
    	return l.next;
    }
}

