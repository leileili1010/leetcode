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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (l1 != null || l2 != null || carry != 0) {
            int x = l1 == null? 0: l1.val; // x = 2
            int y = l2 == null? 0: l2.val; // y = 5
            int sum = x + y + carry; // sum = 7
            int digit = sum % 10; // digit = 7
            carry = sum / 10; // carry = 0

            cur.next = new ListNode(digit);
            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;   
    }
}