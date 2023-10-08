# 160. Intersection of Two Linked Lists

[Leetcode 160 (easy)][160]

[160]: https://leetcode.com/problems/intersection-of-two-linked-lists/description/

```Java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Lei's method;
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        ListNode curA = headA;
        ListNode curB = headB;
        
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                curA = curA.next;
            }
        } else {
            for (int i = 0; i < lengthB - lengthA; i++) {
                curB = curB.next;
            }
        }

        if (curA == curB) return curA;

        while (curA != null && curB != null && curA.next != null && curB.next != null) {
            if (curA.next == curB.next) return curA.next;
            curA = curA.next;
            curB = curB.next; 
        }

        return null;
    }

    public int getLength(ListNode head) {
        int length  = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }  
}
```