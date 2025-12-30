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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode odd = head;
        ListNode even = head.next;

        // maintain the evenHead;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            // change pointers for odd list
            odd.next = odd.next.next;
            odd = odd.next;

            // change pointers for even list
            even.next = even.next.next;
            even = even.next;
        }
        
        // assign even list at the end of odd list
        odd.next = evenHead;
        
        return head;
    }
}