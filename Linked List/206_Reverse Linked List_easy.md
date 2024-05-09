# 206. Reverse Linked List

[Leetcode 206 (Easy)][206]

[206]: https://leetcode.com/problems/reverse-linked-list/

- two pointers

![alt text](image-5.png)

- recursion

![alt text](image-6.png)

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
// 双指针法 
// Time: O(n), Space: O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = head;
        ListNode temp = null;
        ListNode pre = null;

        while (cur != null) {
            temp = cur.next; //存储下一个位置以便于cur移动
            cur.next = pre; // 断开原链接，再翻转链接；
            pre = cur; // 保存当下位置作为previous 位置
            cur = temp; //cur移动到下一个位置
        }
        return pre;
    }
}

// a smilar to above
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode cur = head;
        ListNode temp = head;

        while (cur != null) {
            cur = cur.next;
            temp.next = cur.next;
            cur.next = head;
            head = cur;
            cur = temp;
        
        }
        return head;
    }
}

// 递归法
class Solution {
    public ListNode reverseList(ListNode head) {
        return reverse(null, head); // prev = null, cur = head;
    }

    private ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = null;
        temp = cur.next;// 先保存下一个节点
        cur.next = prev;// 反转
        // 更新prev、cur位置
        // prev = cur;
        // cur = temp;
        return reverse(cur, temp); // here prev = cur, cur = temp 
    }
}

// 从后向前递归（比较难理解）
class Solution {
    ListNode reverseList(ListNode head) {
        // 边缘条件判断
        if(head == null) return null;
        if (head.next == null) return head;
        
        // 递归调用，翻转第二个节点开始往后的链表
        ListNode last = reverseList(head.next);
        // 翻转头节点与第二个节点的指向
        head.next.next = head;
        // 此时的 head 节点为尾节点，next 需要指向 NULL
        head.next = null;
        return last;
    } 
}

```