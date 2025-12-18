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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy, fast = dummy;

        // let fast go n steps
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // slow and fast move forward together until fast.next is null
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // remove
        slow.next = slow.next.next;

        return dummy.next;
    }
}