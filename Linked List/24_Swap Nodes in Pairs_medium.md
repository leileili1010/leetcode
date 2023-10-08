# 24. Swap Nodes in Pairs
[Leetcode 24 (medium)][24]

[24]: https://leetcode.com/problems/swap-nodes-in-pairs/

**Constraints:**
- number of nodes range [0, 100], means the list could be empty

## Approach
- Set dummy node to avoid edge case when linked list is empty or only one node;
- Although we could use multiple pointers in solving this problem, there must be one pointing at the node before the two nodes we want to swap, or the swap prosess is impossible.
- neetcode's method is easier to understand, everytime we set nextpair pointer (to move cur to) and second pointer(to link)
- everytime we move pre to cur (the node right before the two nodes to be swapped) and move cur to next pair
- Be careful about the while loop condition, cur != null must be written ahead of cur.next != null


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