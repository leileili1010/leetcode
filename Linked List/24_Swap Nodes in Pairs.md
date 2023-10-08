# 24. Swap Nodes in Pairs
[Leetcode 24 (medium)][24]

[24]: https://leetcode.com/problems/swap-nodes-in-pairs/

**Constraints:**
- number of nodes range [0, 100], means the list could be empty

## Approach



```Java
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


//neetcode's method: 5 pointers
class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        ListNode nextPair;
        ListNode second;

        while (cur != null && cur.next != null) {
            nextPair = cur.next.next;
            second = cur.next;

            cur.next = nextPair;
            second.next = cur;
            pre.next = second;

            pre = cur;
            cur = nextPair;
        }
        return dummy.next;
    }
}

// Lei's method : two pointers
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = dummy.next;

        while (pre.next != null && pre.next.next != null) {
            cur = cur.next;

            pre.next.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            
            pre = pre.next.next;
            cur = pre.next;
        }
        return dummy.next;
    }
}
```