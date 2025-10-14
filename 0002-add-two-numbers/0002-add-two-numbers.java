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
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 == null? 0: l1.val; // v1 = 3
            int v2 = l2 == null? 0: l2.val; // v2 = 1
            int sum = v1 + v2 + carry; // sum = 4
            int digit = sum % 10; // digit = 4
            carry = sum / 10; // carray = 0
            ListNode node = new ListNode(digit); // node.val = 4
            
            cur.next = node;
            cur  = node;

            if (l1 != null) l1 = l1.next; // l1 = 3
            if (l2 != null) l2 = l2.next; // l2 = 1
        }

        return dummy.next;
    }
}