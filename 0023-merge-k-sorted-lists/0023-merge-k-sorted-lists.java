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
    public ListNode mergeKLists(ListNode[] lists) {
        int m = lists.length;
        if (m == 0) return null;

        // i: 每一组合并中左边的index
        // i+step: 每一组合并中右边的下标
        // i += step*2： 下一组合并中左边的下标
        // [[.0..] [.1..] [.2..] [.3..] [.4..]]
        // [[.0.1.] [...] [.2.3.] [...] [.4..]]
        // [[.0.2.] [...] [...] [...] [.4..]]

      for (int step = 1; step < m; step *= 2) {
        for (int i = 0; i < m - step; i += step * 2) {
            lists[i] = mergeTwoLists(lists[i], lists[i+step]);
        }
      }
      return lists[0];
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        cur.next = list1 != null? list1: list2;
        return dummy.next; 
    }
}