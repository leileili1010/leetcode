# 19. Remove Nth Node From End of List

[Leetcode 19 (medium)][19]

[19]: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

**constraints:**
- at least will be one node in the linked list
- nth from the end of the list <= the number of nodes

**Examples:**
- Example 1: Input: head = [1,2,3,4,5], n = 2

    Output: [1,2,3,5]

 - Example 2: Input: head = [1], n = 1
    
    Output: []

- Example 3: Input: head = [1,2], n = 1
    
    Output: [1]

## Approach
- because deleting head node and other node is different, so I first set up a dummy node to make them same.
- if we want to delete a node, we want to get to the node right before the node to be deleted.
- set up two pointers, the slow one and the fast one, both pointing to the dummy node. What I want to achieve is that when the fast one hits the last node, the slow pointer gets to the node right before the the node to be deleted. 
  - first, let fast pointer to move n steps, when it is done, slow pointer is still at dummy node. 
  - now move them at the same time until fast node hits the last node (fast.next != null). At this point, slow pointer is at the node right befor the node to be deleted. Then we can break the link. 
- return the head node (dummy.next);

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

// method 1: two pointers
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast =fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
        
    }
}
// Time complexity:O(N)
// Space complexity:O(1)

// method 2: one pointers
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        int length = 0;

        while (cur != null) {
            length++;
            cur = cur.next;
        }

        cur = dummy;
        for (int i = 0; i < length - (n+1); i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
        
    }
}
// Time complexity:O(N)
// Space complexity:O(1)

```