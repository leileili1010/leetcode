# 203. Remove Linked List Elements
[Leetcode 203 (Easy)][203]

[Neetcode walkthrough][neetcode203]

[203]:https://leetcode.com/problems/remove-linked-list-elements/description/
[neetcode203]: https://www.youtube.com/watch?v=JI71sxtHTng&list=PLot-Xpze53leU0Ec0VkBhnf4npMRFiNcB&index=3

## Approach
**Conditions:**

- could not an empty linked list;
- After removing nodes, it could be empty;

**Solution:**
- we set up dummy node as the way how to remove head and the other nodes are different. With dummy node previous to head, we make it the same way to delete all head.
- one pointer method: must have cur.next != null, or run into error. This is becuase when cur move to the last node, cur.next.val refer to null.val - does not work. 
- Must grasp both one pointer and two pointer methods.

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

// one pointer method
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // if (head == null) return head (still works if added this statement)
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;

        while (cur != null && cur.next != null) { // must have cur.next != null, or run into error. 
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }
            else cur = cur.next;
        }
        return dummy.next;
    }
}


// two pointers
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // if (head == null)  return head;
            
        // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) { // no need to consider cur.next != null, as with pre pointer, we will only compare cur.val and val, so would not run into error
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}

```