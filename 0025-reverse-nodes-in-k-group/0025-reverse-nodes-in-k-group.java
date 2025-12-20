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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kth = findKth(groupPrev, k);
            if (kth == null) break;

            ListNode groupNext = kth.next;
            ListNode next = groupNext;
            ListNode cur = groupPrev.next;

            while (cur != groupNext) {
                ListNode temp = cur.next;
                cur.next = next;
                next = cur;
                cur = temp;
            }

            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }
        
        return dummy.next;
    }

    private ListNode findKth(ListNode head, int k) {
        ListNode cur = head;
        for (int i = 0; i < k && cur != null; i++) {
            cur = cur.next;
        }
        return cur;
    }
}