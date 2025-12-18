# 19. Remove Nth Node From End of List

## Approach
想象有一把长度固定的尺子，左端点在链表头部，右端点在正数第 n 个节点。向右移动尺子，当尺子右端点到达链表末尾时，左端点就在倒数第 n 个节点。

由于需要删除节点，我们需要找倒数第 n 个节点的前一个节点（倒数第 n+1 个节点），这样才能做删除操作。

修改：左端点在链表头部，右端点在正数第 n+1 个节点。向右移动尺子，当尺子右端点到达链表末尾时，左端点就在倒数第 n+1 个节点。

细节：如果 n 等于链表长度呢？没有正数第 n+1 个节点。难道要特判这种情况？

不需要。我们可以在头节点的前面插入一个哨兵节点（dummy node），把它当作链表的头节点，这样就有正数第 n+1 个节点了。换句话说，如果遇到需要删除头节点的题目，添加哨兵节点可以简化代码逻辑，请记住这个技巧。


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

        // let fast go n steps
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // slow and fast move forward together until fast.next is null
        while (fast.next != null) {
            slow = slow.next;
            fast =fast.next;
        }

        // remove
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