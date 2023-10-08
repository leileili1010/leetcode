# 21. Merge Two Sorted Lists
[Leetcode 21 (Easy)][21]

[Neetcode walkthrough][neetcode21]


## Approach

**conditions:**
- both linked lists are sorted;
- one list could be longer than the other;
- list1 and list2 could be empty. How to take care of edge cases?

**Solution:**
- create a empty linked list, set two pointers, one is dummy(head), the other is tail.
  - benefit of having dummy is we dont have to deal with edge cases if list1 && list two = null;
- we move along list1 and list2. if list1.val > list2.val, we put list1 in the empty linked list, otherwise list2. Need to move tail to the newly linked node as well.
  - here no need to set another pointers to move along list1 and list2 as we are require to slice list1 and list2 here.
  - to slice a list, just move along it using its first node.
- what if one list is longer than the other one? We need to check if one of list1 and list2 are != null, then link the rest of the longer linked list to our new list.


[21]: https://leetcode.com/problems/merge-two-sorted-lists/description/
[neetcode21]: https://www.youtube.com/watch?v=XIdigk956u0&list=PLot-Xpze53leU0Ec0VkBhnf4npMRFiNcB&index=5

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

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       ListNode dummy = new ListNode(-1); 
       ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) tail.next = list1; // when one list is longer than the other
        else tail.next = list2;
        // tail.next = (list1 != null)? list1: list2;

        return dummy.next;
    }
}


//recursion method
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list2.next, list1);
                return list2;
            }
        }
        return list1 == null ? list2 : list1;
    }
}

```