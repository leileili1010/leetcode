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

    // Find length
    public static int getLength(ListNode head) {
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        return length;
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
        ListNode curNode = node1;
        while (curNode != null) {
            System.out.print(cur.val + " ");
            curNode = curNode.next;
        }
    }    
}
```

## Implementation - creat, read, update and remove
```Java
public class ListNode {
    int val;
    ListNode next;

     public ListNode(int val){
        this.val = val;
    }
}

public class MyLinkedList {
    private ListNode dummy = new ListNode(-1); //dummy node for easier operation

    // insert a new node at certain location
    public void add(int location, int value) {
        ListNode pre = dummy; // start from dummy node, and we want to get to the previous node (right before node at certain location)
        for (int i = 0; i < location; ++i) {
            pre = pre.next
        }

        ListNode newNode = new ListNode(value);
        newNode.next = pre.next; //always link new node to the node after it first 
        pre.next = newNode; // then break link with old node
    }

    // read or get a node's value at certain location
     public int get(int location) {
        Listnode curNode = dummy.next // start from head node not dummy
        for (int i = 0; i < location; ++i) {
            curNode = curNode.next;
        }
        return curNode.val;
     }

      // update value of a node at certain postion      
      public void set(int location, int newValue) {
        Listnode curNode = dummy.next // start from head node not dummy
        for (int i = 0; i < location; ++i) {
            curNode = curNode.next;
        }
        curNode.val = newValue;
     }

     // remove node at certain postion
     public int remove(int location) {
         ListNode pre = dummy; // start from dummy node, and we want to get to the previous node (right before node at certain location)
        for (int = 0; i < location; ++i) {
            pre = pre.next;
        }
        res = pre.next;
        pre.next = pre.next.next;

        return res;
     }

}    
```