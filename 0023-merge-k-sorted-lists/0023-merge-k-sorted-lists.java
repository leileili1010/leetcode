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
        // minHeap: 3 heads
        // poll top, if top.next not null, add to minheap, top add to res
        // O(Nlogk)
        // O(k)

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> (a.val-b.val));
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        
        for(ListNode node: lists) {
            if (node != null) minHeap.offer(node);
        }

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            if (node.next != null) {
                minHeap.offer(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }

        return dummy.next;
    }
}