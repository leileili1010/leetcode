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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMiddleNode(head);
        ListNode head2 = reverseList(mid);

        while (head2 != null) {
            if (head.val != head2.val) return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    private ListNode findMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // 如果是偶数个节点，停留在后半部分第一个点
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}