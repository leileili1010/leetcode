# 61. Rotate List
[Leetcode 61 (medium)][61]

[61]: https://leetcode.com/problems/rotate-list/description/



```java
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

//Lei's method
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode cur = head;
        ListNode pre = head;
        int length = 0;
       
        while(cur != null) {
            length++;
            cur = cur.next;
        }

        if (k >= length) k = k % length;
        int step = length - k -1;

        for (int i = 0; i < step; i++) {
            pre = pre.next;
        }

        cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }

        cur.next = head;
        head = pre.next;
        pre.next = null;

        return head;
    }
}
```