# Middle of the Linked List
[Leetcode 876 (Easy)][876]

[876]: https://leetcode.com/problems/middle-of-the-linked-list/

## Approach
- initilize two pointer fast and slow respectively
- while **fast is not null** and also fast.next is not null, move the fast 2 steps ahead and the slow one step ahead in each iteration
  - Attention: "fast != null" must be there, or when number of nodes is even and fast moves to null (slow moves at middle), the while loop will check again "while (fast != null && fast.next != null) ". with out "fast != null", it will run into error, as null.next is a syntax error.
- after the loop, return the slow which is the middle of the list

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

// when number of nodes is even, middle means the right one
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

// when number of nodes is even, middle means the left one
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
```
