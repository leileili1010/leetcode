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
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> (a.val - b.val));

        for (ListNode node: lists) {
            if (node != null) minHeap.offer(node);
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (!minHeap.isEmpty()) {
            ListNode top = minHeap.poll();
            cur.next = top;
            cur = cur.next;
            if (top.next != null) minHeap.offer(top.next);
        }

        return dummy.next;
    }
}