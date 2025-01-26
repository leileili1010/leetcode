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
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode leftDummy = new ListNode(-1);
        ListNode rightDummy = new ListNode(-1);
        ListNode left = leftDummy;
        ListNode right = rightDummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                left.next = cur;
                left = left.next;
            } else {
                right.next = cur;
                right = right.next;
            }
            cur = cur.next;
        }

        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;

    }
}