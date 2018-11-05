/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
         if(lists == null || lists.length == 0)
        	return null;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode> () {
        	@Override
        	public int compare(ListNode a, ListNode b){
        		return a.val - b.val;
        	}
        });
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for(ListNode l : lists){
        	if(l != null)
        		q.add(l);
        }

        while(!q.isEmpty()){
        	ListNode node = q.poll();
        	cur.next = node;
        	cur = cur.next;
        	if(cur.next != null){
        		q.add(cur.next);
        	}
        }
        return dummy.next;
    }
}