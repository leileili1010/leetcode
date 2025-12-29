/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // dummy and cur
        // put head of each linkedlist into minHeap
        // pull top
            // if head.next is not null, put head.next to minHeap
            // cur.next = top
            // cur = cur.next;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> (a.val - b.val));

        for (ListNode node: lists) {
           if (node != null) minHeap.offer(node);
        } 

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (!minHeap.isEmpty()) {
            ListNode top = minHeap.poll();
            if (top.next != null) minHeap.offer(top.next);
            cur.next = top;
            cur = cur.next;
        }

        return dummy.next;
    }
}