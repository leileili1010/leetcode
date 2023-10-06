# Linked List Learning Notes
## How to construct a linked list?
- Construct linked list
- Traverse
- How to find length?

```Java
public class ListNode {
    // 结点的值
    int val;

    // 下一个结点
    ListNode next;

    // 节点的构造函数(无参)
    public ListNode() {
    }

    // 节点的构造函数(有一个参数)
    public ListNode(int val) {
        this.val = val;
    }

    // 节点的构造函数(有两个参数)
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class LinkedListExample {
     public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

    // Traverse a linked list
    let curNode = node1;
    while (curNode) {
        System.out.print(cur.val + " ");
        curNode = curNode.next;
    }

    
    }    
}
```

## Implementation - creat, read, update and remove
