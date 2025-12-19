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
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> (a.val-b.val));

        for (ListNode node: lists) {
            while (node != null) {
                ListNode temp = node.next;
                node.next = null;
                minHeap.offer(node);
                node = temp;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!minHeap.isEmpty()) {
            cur.next = minHeap.poll();
            cur = cur.next;
        }

        return dummy.next;
    }
}